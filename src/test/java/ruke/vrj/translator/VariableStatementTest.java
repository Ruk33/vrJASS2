package ruke.vrj.translator;

import com.google.common.collect.ImmutableSet;
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
public class VariableStatementTest {

  @Test
  public void test() {
    Symbol variable = new Symbol(null, "foo", "integer", ImmutableSet.of(SymbolFlag.LOCAL), null);
    Expression variableStatement = new VariableStatement(variable, null);
    Assert.assertEquals("local integer foo", variableStatement.toString());

    variable = new Symbol(null, "foo", "integer", ImmutableSet.of(SymbolFlag.LOCAL, SymbolFlag.ARRAY), null);
    variableStatement = new VariableStatement(variable, null);
    Assert.assertEquals("local integer array foo", variableStatement.toString());

    variable = new Symbol(null, "foo", "foo", ImmutableSet.of(SymbolFlag.LOCAL, SymbolFlag.STRUCT), null);
    variableStatement = new VariableStatement(variable, null);
    Assert.assertEquals("local integer foo", variableStatement.toString());

    variable = new Symbol(null, "foo", "integer", ImmutableSet.of(SymbolFlag.LOCAL), null);
    variableStatement = new VariableStatement(variable, new RawExpression("bar"));
    Assert.assertEquals("local integer foo = bar", variableStatement.toString());
  }

}