package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 18/12/2016.
 */
public class GlobalDefinitionTest {

  @Test
  public void checkAlreadyDefined() {
    String code = String.join("\n",
        "globals",
        "integer i",
        "integer i",
        "integer foo",
        "endglobals"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "3:8 - Variable i is already defined",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkDefinedType() {
    String code = String.join("\n",
        "globals",
        "integer i",
        "foo bar",
        "endglobals"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "3:0 - foo is not defined",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkTypeCompatibility() {
    String code = String.join("\n",
        "globals",
        "integer i = true",
        "integer n = foo",
        "endglobals"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(2, compiler.getAllErrors().size());
    Assert.assertEquals(
        "2:12 - Incompatible type. Expected integer but boolean given",
        compiler.getAllErrors().get(0).getMessage()
    );
    Assert.assertEquals(
        "3:12 - foo is not defined",
        compiler.getAllErrors().get(1).getMessage()
    );
  }

  @Test
  public void checkArrayAssignment() {
    String code = String.join("\n",
        "globals",
        "integer array i = 2",
        "endglobals"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "2:18 - Arrays can not be initialized (yet)",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkConstant() {
    String code = String.join("\n",
        "globals",
        "constant integer i = 42",
        "endglobals",
        "function foo takes nothing returns nothing",
        "set i = 43",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "5:4 - Cannot assign a value to constant variable",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkIntegerIndex() {
    String code = String.join("\n",
        "globals",
        "integer array i",
        "endglobals",
        "function foo takes nothing returns nothing",
        "set i[1] = 42",
        "set i[true] = 43",
        "set i[foo] = 44",
        "set i[bar] = 45",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(3, compiler.getAllErrors().size());
    Assert.assertEquals(
        "6:6 - true is not a numeric expression",
        compiler.getAllErrors().get(0).getMessage()
    );
    //Assert.assertEquals(
    //    "7:6 - foo is not a variable",
    //    compiler.getAllErrors().get(1).getMessage()
    //);
    Assert.assertEquals(
        "7:6 - foo is not a numeric expression",
        compiler.getAllErrors().get(1).getMessage()
    );
    Assert.assertEquals(
        "8:6 - bar is not defined",
        compiler.getAllErrors().get(2).getMessage()
    );
  }

}
