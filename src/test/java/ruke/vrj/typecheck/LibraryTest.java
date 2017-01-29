package ruke.vrj.typecheck;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.compiler.Compiler;

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
public class LibraryTest {

  @Test
  public void initializerMustBeFunction() {
    final String code = String.join("\n",
        "library foo initializer init",
          "function init takes nothing returns nothing",
          "endfunction",
        "endlibrary",
        "library bar initializer init",
          "globals",
            "integer init",
          "endglobals",
        "endlibrary",
        "library baz initializer init",
          "function init takes integer i returns nothing",
          "endfunction",
        "endlibrary",
        "library bez initializer init",
        "endlibrary"
    );

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(3, compiler.getResults().size());
    Assert.assertEquals(
        "(5,24,28): Invalid initializer. It must be a function with no parameters",
        compiler.getResults().get(0).toString()
    );
    Assert.assertEquals(
        "(10,24,28): Invalid initializer. It must be a function with no parameters",
        compiler.getResults().get(1).toString()
    );
    Assert.assertEquals(
        "(14,24,28): Invalid initializer. It must be a function with no parameters",
        compiler.getResults().get(2).toString()
    );
  }

  @Test
  public void requirementsMustBeLibraries() {
    final String code = String.join("\n",
        "library foo requires bar",
        "endlibrary",
        "library bar requires integer",
        "endlibrary"
    );

    final Compiler compiler = new Compiler();

    compiler.compile(code);

    Assert.assertEquals(1, compiler.getResults().size());
    Assert.assertEquals(
        "(3,21,28): Invalid library requirement. Only libraries are valid",
        compiler.getResults().get(0).toString()
    );
  }

}
