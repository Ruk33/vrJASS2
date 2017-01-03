package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 18/12/2016.
 */
public class NativesTest {

  @Test
  public void checkAlreadyDefined() {
    String code = String.join("\n",
        "native ConvertPlayerUnitEvent takes integer i returns nothing",
        "native ConvertPlayerUnitEvent takes integer i returns nothing",
        "native Lorem takes integer i returns nothing"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "2:7 - Function ConvertPlayerUnitEvent is already defined",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkParamTypesAreDefined() {
    String code = String.join("\n",
        "native ConvertPlayerUnitEvent takes integer i, lorem bar returns integer"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "1:47 - lorem is not defined",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkDefinedType() {
    String code = String.join("\n",
        "native ConvertPlayerUnitEvent takes integer i returns bar",
        "native Lorem takes integer i returns integer"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "1:54 - bar is not defined",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

}
