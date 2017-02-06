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
public class SymbolTableTest {

  @Test
  public void resolveItself() {
    final Symbol foo = new Symbol(null, "foo", "nothing", ImmutableSet.of(), null);
    Assert.assertEquals(foo, foo.children.resolve("foo"));
  }

  @Test
  public void resolveNamespace() {
    final Symbol main = new Symbol(null, "main", "nothing", null, null);
    final Symbol foo = new Symbol(main, "foo", "nothing", ImmutableSet.of(), null);
    final Symbol bar = new Symbol(foo, "bar", "nothing", ImmutableSet.of(), null);

    main.children.define(foo);
    foo.children.define(bar);

    Symbol result = main.children.resolve("foo.bar");

    Assert.assertEquals(bar, result);
  }

  @Test
  public void resolve() {
    final Symbol main = new Symbol(null, "main", "nothing", null, null);
    final Symbol integer = new Symbol(main, "integer", "integer", ImmutableSet.of(), null);
    final Symbol foo = new Symbol(main, "foo", "integer", ImmutableSet.of(), null);

    main.children.define(integer);
    main.children.define(foo);

    Assert.assertEquals(integer, foo.children.resolve("integer"));
  }
}
