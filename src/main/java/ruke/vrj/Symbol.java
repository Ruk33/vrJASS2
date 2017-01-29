package ruke.vrj;

import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * MIT License
 *
 * Copyright (c) 2017 Franco Montenegro
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class Symbol {

  private static int ID = 0;

  public static final Symbol NOTHING = new Symbol(
      null, "nothing", "nothing", ImmutableSet.of(SymbolFlag.TYPE), null
  );

  /**
   * Unique id of the symbol. It is used as a virtual type for structs
   */
  public final int id;

  public final Symbol parent;

  /**
   * Name of the initializer function
   */
  public String initializer = "";

  public final String name;

  /**
   * Name of the type (in function, it refers to the return type)
   */
  public final String type;

  public ImmutableSet<SymbolFlag> flags;

  public final SymbolTable children;

  /**
   * Node where it was declared
   */
  public final ParserRuleContext declaration;

  /**
   * Name of the symbols that extends from
   */
  public final ArrayList<String> _extends;

  public final ArrayList<Symbol> params;

  /**
   * If a method is overridden we need to know all the implementation to later translate
   * For example:
   *
   * struct foo
   *  method lorem ...
   *  endmethod
   * endstruct
   *
   * struct bar extends foo
   *  method lorem ...
   *  endmethod
   * endstruct
   *
   * The implementations set will only be populated using the {registerImplementationIfNecessary}
   * method. For the previous example to work:
   *
   * Symbol lorem = fetch lorem from bar
   * lorem.registerImplementationIfNecessary()
   *
   * Now the lorem symbol from the foo struct will contain the implementation from bar
   */
  public ImmutableSet<Symbol> implementations;

  public Symbol(
      final Symbol parent,
      final String name,
      final String type,
      final ImmutableSet<SymbolFlag> flags,
      final ParserRuleContext declaration
  ) {
    this.id = Symbol.ID++;
    this.parent = parent;
    this.name = name;
    this.type = type;
    this.flags = flags != null ? ImmutableSet.copyOf(flags) : ImmutableSet.of();
    this.children = new SymbolTable(parent == null ? null : parent.children, this);
    this.declaration = declaration;
    this._extends = new ArrayList();
    this.params = new ArrayList<>();
    this.implementations = ImmutableSet.of();

    if (this.flags.contains(SymbolFlag.ARRAY)) {
      final Symbol getBracket = new Symbol(this, "[]", type, null, declaration);
      final Symbol setBracket = new Symbol(this, "[]=", "nothing", null, declaration);

      final Symbol getBracketIndex = new Symbol(getBracket, "index", "integer", ImmutableSet.of(SymbolFlag.VARIABLE), declaration);
      final Symbol setBracketIndex = new Symbol(setBracket, "index", "integer", ImmutableSet.of(SymbolFlag.VARIABLE), declaration);
      final Symbol setBracketValue = new Symbol(setBracket, "value", type, ImmutableSet.of(SymbolFlag.VARIABLE), declaration);

      getBracket.addParam(getBracketIndex);
      setBracket.addParam(setBracketIndex);
      setBracket.addParam(setBracketValue);

      this.children.define(getBracket);
      this.children.define(setBracket);
    }
  }

  public Symbol() {
    this(null, "__vrj__", null, null, null);

    final Symbol integer = new Symbol(this, "integer", "integer", ImmutableSet.of(SymbolFlag.TYPE), null);
    final Symbol real = new Symbol(this, "real", "real", ImmutableSet.of(SymbolFlag.TYPE), null);

    integer.addExtends("real");
    real.addExtends("integer");

    this.children.define(Symbol.NOTHING);
    this.children.define(integer);
    this.children.define(real);
    this.children.define(new Symbol(this, "handle", "handle", ImmutableSet.of(SymbolFlag.TYPE), null));
    this.children.define(new Symbol(this, "string", "string", ImmutableSet.of(SymbolFlag.TYPE), null));
    this.children.define(new Symbol(this, "code", "code", ImmutableSet.of(SymbolFlag.TYPE), null));
    this.children.define(new Symbol(this, "boolean", "boolean", ImmutableSet.of(SymbolFlag.TYPE), null));
    this.children.define(new Symbol(this, "null", "null", ImmutableSet.of(SymbolFlag.TYPE), null));
  }

  /**
   * Reset the counter of the ids (useful for tests)
   */
  public static void resetIdCounter() {
    Symbol.ID = 0;
  }

  public final void addFlag(final SymbolFlag flag) {
    this.flags = ImmutableSet.<SymbolFlag>builder().addAll(this.flags).add(flag).build();
  }

  public final void addExtends(final String _extends) {
    if (!_extends.isEmpty()) {
      this._extends.add(_extends);
    }
  }

  public final void addParam(final Symbol param) {
    this.params.add(param);
    this.children.define(param);
  }

  /**
   * Fetch all possible types of a symbol
   * @param fetchedTypes Already fetched types (prevent possible stack overflows)
   * @return All possible types of symbol
   */
  private final ArrayList<Symbol> getTypes(final ArrayList<Symbol> fetchedTypes) {
    Symbol type = this.children.resolve(this.type);

    if (fetchedTypes.contains(type)) {
      return fetchedTypes;
    }

    fetchedTypes.add(type);

    for (final String extend : this._extends) {
      type = this.children.resolve(extend);

      if (!fetchedTypes.contains(type)) {
        fetchedTypes.addAll(type.getTypes(fetchedTypes));
      }
    }

    return fetchedTypes;
  }

  public final ArrayList<Symbol> getTypes() {
    return this.getTypes(new ArrayList<>());
  }

  private final void addImplementation(final Symbol implementation) {
    this.implementations =
        ImmutableSet.
        <Symbol>builder().
        addAll(this.implementations).
        add(implementation).
        build();
  }

  public final void registerImplementationIfNecessary() {
    if (!this.parent.flags.contains(SymbolFlag.STRUCT)) {
      return;
    }

    if (this.parent._extends.isEmpty()) {
      return;
    }

    for (final String extend : this.parent._extends) {
      final Symbol extendSymbol = this.parent.children.resolve(extend);
      final Symbol overridden = extendSymbol.children.resolve(this.name);

      if (!overridden.equals(Symbol.NOTHING)) {
        overridden.addImplementation(this);
      }
    }
  }

  @Override
  public final String toString() {
    return String.format("{%s(%s): %s}", this.name, this.params, this.type);
  }
}
