package ruke.vrj.translator;

import ruke.vrj.symbol.FunctionSymbol;
import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class CodeExpressionTest {
    
    @Test
    public void test() {
        Symbol a = new FunctionSymbol("a");
        Assert.assertEquals("function a", new CodeExpression().setSymbol(a).translate());
    }
    
}