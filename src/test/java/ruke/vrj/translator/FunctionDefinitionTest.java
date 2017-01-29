package ruke.vrj.translator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.Symbol;
import ruke.vrj.SymbolFlag;

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
public class FunctionDefinitionTest {

  @Test
  public void stubMethod() {
    /*
     * struct person
     *  string name
     *
     *  method getName takes nothing returns string
     *    return this.name
     *  endmethod
     * endstruct
     *
     * struct foo extends person
     *  method getName takes nothing returns string
     *    // implementation A
     *  endmethod
     * endstruct
     *
     * struct bar extends person
     *  method getName takes nothing returns string
     *    // implementation B
     *  endmethod
     * endstruct
     */
    Symbol.resetIdCounter();

    final Symbol main = new Symbol();

    final Symbol person = new Symbol(
        main, "person", "person", ImmutableSet.of(SymbolFlag.STRUCT), null
    );
    final Symbol personPropertyName = new Symbol(
        person, "name", "string", ImmutableSet.of(SymbolFlag.VARIABLE), null
    );
    final Symbol personGetName = new Symbol(
        person, "getName", "string", ImmutableSet.of(SymbolFlag.FUNCTION), null
    );

    personGetName.addParam(
        new Symbol(
            personGetName, "this", person.type, ImmutableSet.of(SymbolFlag.VARIABLE), null
        )
    );

    person.children.define(personPropertyName);
    person.children.define(personGetName);

    final Symbol foo = new Symbol(
        main, "foo", "foo", ImmutableSet.of(SymbolFlag.STRUCT), null
    );
    final Symbol fooGetName = new Symbol(
        foo, "getName", "string", ImmutableSet.of(SymbolFlag.FUNCTION), null
    );

    foo.addExtends("person");

    fooGetName.addParam(
        new Symbol(
            fooGetName, "this", foo.type, ImmutableSet.of(SymbolFlag.VARIABLE), null
        )
    );

    foo.children.define(fooGetName);

    final Symbol bar = new Symbol(
        main, "bar", "bar", ImmutableSet.of(SymbolFlag.STRUCT), null
    );
    final Symbol barGetName = new Symbol(
        bar, "getName", "string", ImmutableSet.of(SymbolFlag.FUNCTION), null
    );

    bar.addExtends("person");

    barGetName.addParam(
        new Symbol(
            barGetName, "this", bar.type, ImmutableSet.of(SymbolFlag.VARIABLE), null
        )
    );

    bar.children.define(barGetName);

    main.children.define(person);
    main.children.define(foo);
    main.children.define(bar);

    personGetName.registerImplementationIfNecessary();
    fooGetName.registerImplementationIfNecessary();
    barGetName.registerImplementationIfNecessary();

    Assert.assertEquals(
        String.join("\n",
            "function person_getName takes integer vtype, integer this returns string",
              "if false then",
              "else if vtype == 12 then",
                "return foo_getName(this)",
              "else if vtype == 15 then",
                "return bar_getName(this)",
              "endif",
              "return person_name[this]",
            "endfunction"
        ),
        new FunctionDefinition(
            personGetName,
            ImmutableList.of(
                new ReturnStatement(
                    new ChainExpression(ImmutableList.of(
                        new VariableExpression(personGetName.children.resolve("this")),
                        new VariableExpression(personPropertyName)
                    ))
                )
            )
        ).toString()
    );
  }

  @Test
  public void method() {
    final Symbol struct = new Symbol(
        null, "foo", "foo", ImmutableSet.of(SymbolFlag.STRUCT), null
    );

    final Symbol method = new Symbol(
        struct, "bar", "nothing", ImmutableSet.of(SymbolFlag.FUNCTION), null
    );

    final Symbol _this = new Symbol(
        method,
        "this",
        struct.type,
        ImmutableSet.of(SymbolFlag.VARIABLE),
        null
    );

    method.addParam(_this);
    struct.children.define(method);

    Assert.assertEquals(
        String.join("\n",
            "function foo_bar takes integer this returns nothing",
              "",
            "endfunction"
        ),
        new FunctionDefinition(method, new ArrayList<Expression>(0)).toString()
    );
  }

  @Test
  public void function() {
    final Symbol function = new Symbol(
        null, "foo", "nothing", ImmutableSet.of(SymbolFlag.FUNCTION), null
    );

    Assert.assertEquals(
        String.join("\n",
            "function foo takes nothing returns nothing",
              "",
            "endfunction"
        ),
        new FunctionDefinition(function, new ArrayList<Expression>(0)).toString()
    );
  }

}