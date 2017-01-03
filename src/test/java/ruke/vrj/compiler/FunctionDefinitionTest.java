package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 18/12/2016.
 */
public class FunctionDefinitionTest {

  @Test
  public void checkAlreadyDefined() {
    String code = String.join("\n",
        "function foo takes nothing returns nothing",
        "endfunction",
        "function foo takes nothing returns nothing",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "3:9 - Function foo is already defined",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkDefinedParamTypes() {
    String code = String.join("\n",
        "function foo takes integer i, foo bar, lorem ipsum returns nothing",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(2, compiler.getAllErrors().size());
    Assert.assertEquals(
        "1:30 - foo is not a valid type",
        compiler.getAllErrors().get(0).getMessage()
    );
    Assert.assertEquals(
        "1:39 - lorem is not defined",
        compiler.getAllErrors().get(1).getMessage()
    );
  }

  @Test
  public void checkReturn() {
    String code = String.join("\n",
        "function foo takes nothing returns bar",
        "endfunction",
        "function lorem takes nothing returns integer",
        "return true",
        "endfunction",
        "function ipsum takes nothing returns boolean",
        "if (false) then",
        "return true",
        "endif",
        "endfunction",
        "function dolor takes nothing returns nothing",
        "return",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(3, compiler.getAllErrors().size());
    Assert.assertEquals(
        "1:35 - bar is not defined",
        compiler.getAllErrors().get(0).getMessage()
    );
    Assert.assertEquals(
        "4:7 - Incompatible type. Expected integer but boolean given",
        compiler.getAllErrors().get(1).getMessage()
    );
    Assert.assertEquals(
        "6:9 - Missing return",
        compiler.getAllErrors().get(2).getMessage()
    );
  }

  @Test
  public void checkCall() {
    String code = String.join("\n",
        "function foo takes integer i, boolean e returns integer",
        "call foo(1, true)",
        "call foo(1)",
        "call foo(1, true, true)",
        "call integer()",
        "return foo(false, i)",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(5, compiler.getAllErrors().size());
    Assert.assertEquals(
        "3:5 - Incorrect argument count. Expected 2 arguments",
        compiler.getAllErrors().get(0).getMessage()
    );
    Assert.assertEquals(
        "4:5 - Incorrect argument count. Expected 2 arguments",
        compiler.getAllErrors().get(1).getMessage()
    );
    Assert.assertEquals(
        "5:5 - integer() is not a function",
        compiler.getAllErrors().get(2).getMessage()
    );
    Assert.assertEquals(
        "6:11 - Incompatible type. Expected integer but boolean given",
        compiler.getAllErrors().get(3).getMessage()
    );
    Assert.assertEquals(
        "6:18 - Incompatible type. Expected boolean but integer given",
        compiler.getAllErrors().get(4).getMessage()
    );
  }

}
