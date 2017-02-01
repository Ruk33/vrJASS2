package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.Symbol;

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
public class AssignmentStatementTest {

  @Test
  public void test() {
    final Symbol variableSymbol = new Symbol(null, "foo", "integer", null, null);

    final Expression index = new RawExpression("42");
    final Expression value = new RawExpression("bar");

    final Expression variable = new VariableExpression(variableSymbol, null);
    final Expression variableArray = new VariableExpression(variableSymbol, index);

    Assert.assertEquals("set foo = bar", new AssignmentStatement(variable, value).toString());
    Assert.assertEquals(
        "set foo[42] = bar", new AssignmentStatement(variableArray, value).toString());
  }
}
