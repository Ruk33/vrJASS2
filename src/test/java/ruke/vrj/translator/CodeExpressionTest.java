package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 23/09/2016.
 */
public class CodeExpressionTest {

  @Test
  public void test() {
    Symbol a = new ScopeSymbol("a");
    Assert.assertEquals("function a", new CodeExpression().setSymbol(a).translate());
  }

}