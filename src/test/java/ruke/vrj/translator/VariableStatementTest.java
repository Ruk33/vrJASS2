package ruke.vrj.translator;

import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class VariableStatementTest {

  @Test
  public void test() {
    Symbol foo = new Symbol("foo").setType(new Symbol("bar"));
    Expression baz = new RawExpression("baz");

    Assert.assertEquals(
        "bar foo = baz",
        new VariableStatement().setSymbol(foo).append(baz).translate()
    );

    foo.addModifier(Modifier.LOCAL);

    Assert.assertEquals(
        "local bar foo = baz",
        new VariableStatement().setSymbol(foo).append(baz).translate()
    );
  }

}