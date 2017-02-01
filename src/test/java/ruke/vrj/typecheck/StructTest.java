package ruke.vrj.typecheck;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.compiler.Compiler;

/**
 * MIT License
 *
 * <p>Copyright (c) 2017 Franco Montenegro
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class StructTest {

  @Test
  public void validExtend() {
    final String code =
        String.join(
            "\n",
            "struct foo extends bar",
            "endstruct",
            "struct bar extends array",
            "endstruct",
            "struct baz extends integer",
            "endstruct",
            "library lorem",
            "struct ipsum",
            "endstruct",
            "endlibrary",
            "struct something extends lorem.ipsum",
            "endstruct");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(5,19,26): Structs can only extend from struct or array",
        compiler.getResults().get(0).toString());
  }

  @Test
  public void validInitializer() {
    final String code =
        String.join(
            "\n",
            "struct foo",
            "static method onInit takes nothing returns nothing",
            "endmethod",
            "endstruct",
            "struct bar",
            "method onInit takes nothing returns nothing",
            "endmethod",
            "endstruct",
            "struct baz",
            "static method onInit takes integer i returns nothing",
            "endmethod",
            "endstruct");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(2, compiler.getResults().size());
    Assert.assertEquals(
        "(6,7,13): Struct initializer must be static and must take no parameters",
        compiler.getResults().get(0).toString());
    Assert.assertEquals(
        "(10,14,20): Struct initializer must be static and must take no parameters",
        compiler.getResults().get(1).toString());
  }

  @Test
  public void chainExpression() {
    final String code =
        String.join(
            "\n",
            "struct foo",
            "public method bar takes nothing returns foo",
            "return this",
            "endmethod",
            "endstruct",
            "function baz takes nothing returns nothing",
            "local foo f",
            "call f.bar()",
            "call f.bar().bar()",
            "call f.baz()",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(10,7,10): Function baz is not defined", compiler.getResults().get(0).toString());
  }

  @Test
  public void inheritance() {
    final String code =
        String.join(
            "\n",
            "struct Person",
            "endstruct",
            "struct Foo extends Person",
            "endstruct",
            "struct Bar extends Person",
            "endstruct",
            "struct Baz",
            "endstruct",
            "function lorem takes nothing returns nothing",
            "local Foo foo",
            "local Bar bar",
            "local Baz baz",
            "local Person person = baz",
            "set person = foo",
            "set person = bar",
            "set person = baz",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(2, compiler.getResults().size());
    Assert.assertEquals("(13,22,25): Incompatible type", compiler.getResults().get(0).toString());
    Assert.assertEquals("(16,13,16): Incompatible type", compiler.getResults().get(1).toString());
  }
}
