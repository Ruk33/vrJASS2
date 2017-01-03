package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class VariableExpressionTest {

  @Test
  public void test() {
    Symbol foo = new Symbol("foo");
    Expression bar = new BracketExpression().append(new RawExpression("bar"));

    Assert.assertEquals(
        "foo[bar]",
        new VariableExpression().setSymbol(foo).append(bar).translate()
    );

    Assert.assertEquals(
        "foo",
        new VariableExpression().setSymbol(foo).translate()
    );
  }

}