package ruke.vrj.typecheck;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.compiler.Compiler;

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
public class ExpressionTest {

  @Test
  public void codeType() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local code c",
            "set c = function foo",
            "set c = function bar",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
  }

  @Test
  public void logicalExpression() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local boolean b",
            "set b = true or b",
            "set b = b and false",
            "set b = 1 or false",
            "set b = true or 1",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(2, compiler.getResults().size());
    Assert.assertEquals(
        "(5,8,9): Expected boolean expression", compiler.getResults().get(0).toString());
    Assert.assertEquals(
        "(6,16,17): Expected boolean expression", compiler.getResults().get(1).toString());
  }

  @Test
  public void comparisonExpression() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local boolean b",
            "set b = 1 > false",
            "set b = false < 1",
            "set b = 1 == true",
            "set b = false != 1",
            "set b = false >= 1",
            "set b = 1 <= true",
            "set b = true < false",
            "set b = false > true",
            "set b = false <= false",
            "set b = false >= false",
            "set b = 1 == 1",
            "set b = true != false",
            "set b = 1 < 2.2",
            "set b = 2.1 > 1",
            "set b = 2 <= 2",
            "set b = 3 >= 1.2",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(14, compiler.getResults().size());
    // todo check valid usage in every case
  }

  @Test
  public void mathExpression() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local integer i",
            "set i = 2 % 1.2",
            "set i = 2 + 2.2",
            "set i = 1 - 1.1",
            "set i = 0 * 1.1",
            "set i = 1.1 / 1",
            "set i = -i",
            "set i = false % 1",
            "set i = 1 + true",
            "set i = true - 1",
            "set i = 2 * false",
            "set i = false / true",
            "set i = -false",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(7, compiler.getResults().size());
    Assert.assertEquals("(9,8,13): Expected number", compiler.getResults().get(0).toString());
    Assert.assertEquals("(10,12,16): Expected number", compiler.getResults().get(1).toString());
    Assert.assertEquals("(11,8,12): Expected number", compiler.getResults().get(2).toString());
    Assert.assertEquals("(12,12,17): Expected number", compiler.getResults().get(3).toString());
    Assert.assertEquals("(13,8,13): Expected number", compiler.getResults().get(4).toString());
    Assert.assertEquals("(13,16,20): Expected number", compiler.getResults().get(5).toString());
    Assert.assertEquals("(14,9,14): Expected number", compiler.getResults().get(6).toString());
  }

  @Test
  public void indexArrayMustBeInteger() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local integer array i",
            "set i[1] = 2",
            "set i[i[2]] = 2",
            "set i[i] = 3",
            "set i[1.3] = 3",
            "set i[false] = 4",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(3, compiler.getResults().size());
    Assert.assertEquals(
        "(5,6,7): Array index must be integer", compiler.getResults().get(0).toString());
    Assert.assertEquals(
        "(6,6,9): Array index must be integer", compiler.getResults().get(1).toString());
    Assert.assertEquals(
        "(7,6,11): Array index must be integer", compiler.getResults().get(2).toString());
  }

  @Test
  public void bracketsMustBeUsedOnArrays() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local integer i",
            "set i = 2",
            "set i[1] = 3",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(4,4,8): Variable i is not an array", compiler.getResults().get(0).toString());
  }

  @Test
  public void functionMustExist() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "call foo()",
            "call bar()",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(3,5,8): Function bar is not defined", compiler.getResults().get(0).toString());
  }

  @Test
  public void variableMustExist() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local integer i = 2",
            "set i = i + 1",
            "set i = b",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(4,8,9): Variable b is not defined", compiler.getResults().get(0).toString());
  }
}
