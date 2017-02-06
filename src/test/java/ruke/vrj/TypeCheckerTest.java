package ruke.vrj;

import com.google.common.collect.ImmutableSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * MIT License
 *
 * Copyright (c) 2017 Franco Montenegro
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class TypeCheckerTest {

  @Test
  public void simple() {
    final Symbol main = new Symbol(null, "main", "nothing", null, null);

    final Symbol integer = new Symbol(main, "integer", "integer", ImmutableSet.of(), null);
    final Symbol string = new Symbol(main, "string", "string", ImmutableSet.of(), null);

    Assert.assertFalse(TypeChecker.compatible(integer, string));
  }

  @Test
  public void integerReal() {
    final Symbol main = new Symbol(null, "main", "nothing", null, null);

    final Symbol integer = new Symbol(main, "integer", "integer", ImmutableSet.of(), null);
    final Symbol real = new Symbol(main, "real", "real", ImmutableSet.of(), null);

    integer.addExtends("real");
    real.addExtends("integer");

    main.children.define(integer);
    main.children.define(real);

    Assert.assertTrue(TypeChecker.compatible(integer, real));
    Assert.assertTrue(TypeChecker.compatible(real, integer));
  }

  @Test
  public void complexInheritance() {
    final Symbol main = new Symbol(null, "main", "nothing", null, null);

    final Symbol foo = new Symbol(main, "foo", "foo", ImmutableSet.of(), null);
    final Symbol bar = new Symbol(main, "bar", "bar", ImmutableSet.of(), null);
    final Symbol baz = new Symbol(main, "baz", "baz", ImmutableSet.of(), null);

    baz.addExtends("bar");
    bar.addExtends("foo");

    main.children.define(foo);
    main.children.define(bar);
    main.children.define(baz);

    Assert.assertTrue(TypeChecker.compatible(bar, baz));
    Assert.assertTrue(TypeChecker.compatible(foo, baz));
    Assert.assertFalse(TypeChecker.compatible(baz, foo));
  }

  @Test
  public void validInitializer() {
    Symbol invalid = new Symbol(null, "init", "nothing", ImmutableSet.of(), null);
    final Symbol valid =
        new Symbol(null, "init", "nothing", ImmutableSet.of(SymbolFlag.FUNCTION), null);

    Assert.assertFalse(TypeChecker.isValidInitializer(invalid));
    Assert.assertTrue(TypeChecker.isValidInitializer(valid));

    invalid = new Symbol(null, "init", "nothing", ImmutableSet.of(SymbolFlag.FUNCTION), null);
    invalid.addParam(
        new Symbol(invalid, "foo", "integer", ImmutableSet.of(SymbolFlag.VARIABLE), null));

    Assert.assertFalse(TypeChecker.isValidInitializer(invalid));
  }
}
