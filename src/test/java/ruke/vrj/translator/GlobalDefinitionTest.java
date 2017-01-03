package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class GlobalDefinitionTest {

  @Test
  public void test() {
    Expression globals = new GlobalsStatement();

    Expression bar = new VariableStatement()
        .setSymbol(new Symbol("bar").setType(new Symbol("foo")));
    Expression baz = new VariableStatement()
        .setSymbol(new Symbol("baz").setType(new Symbol("foo")));

    Assert.assertEquals(
        "globals\n" +
            "foo bar\n" +
            "foo baz\n" +
            "endglobals",
        globals.append(bar).append(baz).translate()
    );
  }

}