package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ParamExpressionTest {

  @Test
  public void test() {
    Symbol type = new Symbol("someType");
    Symbol name = new Symbol("someName");

    name.setType(type);

    Assert.assertEquals(
        "someType someName",
        new ParamExpression().setSymbol(name).translate()
    );

    Symbol nothing = new Symbol("nothing");

    Assert.assertEquals(
        "nothing",
        new ParamExpression().setSymbol(nothing).translate()
    );
  }

}