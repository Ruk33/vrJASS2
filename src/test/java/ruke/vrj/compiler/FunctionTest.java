package ruke.vrj.compiler;

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
public class FunctionTest {

  @Test
  public void define() {
    final String code =
        String.join("\n", "function foo takes integer i returns nothing", "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertTrue(compiler.getResults().isEmpty());
  }

  @Test
  public void alreadyDefined() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "endfunction",
            "function foo takes nothing returns nothing",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(3,9,12): Symbol foo is already defined in (1,9,12)",
        compiler.getResults().get(0).toString());
  }

  @Test
  public void alreadyLocalVariableDefined() {
    final String code =
        String.join(
            "\n", "function foo takes integer i returns nothing", "local string i", "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(2,13,14): Symbol i is already defined in (1,19,20)",
        compiler.getResults().get(0).toString());
  }
}
