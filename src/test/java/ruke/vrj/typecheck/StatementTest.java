package ruke.vrj.typecheck;

import org.junit.Assert;
import org.junit.Ignore;
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
public class StatementTest {

  @Test
  public void exitWhenConditionMustBeBoolean() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local boolean bar",
            "loop",
            "exitwhen true",
            "exitwhen bar",
            "exitwhen 1",
            "endloop",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(6,9,10): Exitwhen condition must be a boolean expression",
        compiler.getResults().get(0).toString());
  }

  @Test
  public void variableAssignment() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local integer i",
            "set i = 4",
            "set i = true",
            "local integer array e",
            "set e[4] = 4",
            "set e[5] = true",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(2, compiler.getResults().size());
    Assert.assertEquals("(4,8,12): Incompatible type", compiler.getResults().get(0).toString());
    Assert.assertEquals("(7,11,15): Incompatible type", compiler.getResults().get(1).toString());
  }

  @Test
  public void variableDeclaration() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local integer i = 2",
            "local integer e = false",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals("(3,18,23): Incompatible type", compiler.getResults().get(0).toString());
  }

  @Test
  @Ignore
  public void functionCallMustBeFunction() {
    final String code =
        String.join(
            "\n",
            "struct bar",
            "public method b takes nothing returns nothing",
            "endmethod",
            "endstruct",
            "function foo takes nothing returns nothing",
            "local bar a",
            "call foo()",
            "call a.b",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals("(4,8,12): Incompatible type", compiler.getResults().get(0).toString());
  }

  @Test
  public void returnStatementMustBeCompatible() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns integer",
            "local integer i",
            "return i",
            "return 1",
            "return 1.2",
            "return true",
            "return",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(2, compiler.getResults().size());
    Assert.assertEquals("(6,0,11): Incompatible type", compiler.getResults().get(0).toString());
    Assert.assertEquals("(7,0,7): Incompatible type", compiler.getResults().get(1).toString());
  }

  @Test
  public void ifConditionMustBeBoolean() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local boolean bar",
            "if (bar) then",
            "endif",
            "if true then",
            "endif",
            "if 1 then",
            "endif",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(7,3,4): Expected boolean expression", compiler.getResults().get(0).toString());
  }

  @Test
  public void elseIfConditionMustBeBoolean() {
    final String code =
        String.join(
            "\n",
            "function foo takes nothing returns nothing",
            "local boolean bar",
            "if (true) then",
            "elseif (bar) then",
            "endif",
            "if true then",
            "elseif true then",
            "endif",
            "if true then",
            "elseif 1 then",
            "endif",
            "endfunction");

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(10,7,8): Expected boolean expression", compiler.getResults().get(0).toString());
  }
}
