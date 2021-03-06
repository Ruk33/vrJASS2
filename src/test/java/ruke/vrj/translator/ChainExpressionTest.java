package ruke.vrj.translator;

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
public class ChainExpressionTest {

  @Test
  public void test() {
    final ArrayList<ChainableExpression> chain = new ArrayList<>();

    /*
     * local someStruct foo
     * foo.bar()
     */
    Symbol foo =
        new Symbol(
            null,
            "foo",
            "someStruct",
            ImmutableSet.of(SymbolFlag.VARIABLE, SymbolFlag.LOCAL),
            null);
    Symbol bar = new Symbol(null, "bar", "nothing", ImmutableSet.of(SymbolFlag.FUNCTION), null);

    chain.add(new VariableExpression(foo, null));
    chain.add(new FunctionExpression(bar, new ArrayList<Expression>()));

    Assert.assertEquals("bar(foo)", new ChainExpression(chain).toString());
  }
}
