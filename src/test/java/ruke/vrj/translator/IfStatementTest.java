package ruke.vrj.translator;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

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
public class IfStatementTest {

  @Test
  public void test() {
    final Expression condition = new RawExpression("true");
    final ArrayList<Expression> body = new ArrayList<>();

    Assert.assertEquals(
        "if true then\n" +
            "\n" +
        "endif",
        new IfStatement(condition, body).toString()
    );

    body.add(new RawExpression("call foo()"));

    Assert.assertEquals(
        "if true then\n" +
            "call foo()\n" +
        "endif",
        new IfStatement(condition, body).toString()
    );
  }

}