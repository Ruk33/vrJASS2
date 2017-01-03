package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 23/09/2016.
 */
public class FunctionExpressionTest {
    
    @Test
    public void test() {
        Symbol function = new ScopeSymbol("a");
        
        Expression args = new ExpressionList().append(new RawExpression("my")).append(new RawExpression("arg"));
    
        Assert.assertEquals(
            "a(my, arg)",
            new FunctionExpression().setSymbol(function).append(args).translate()
        );
    
        Assert.assertEquals(
            "a()",
            new FunctionExpression().setSymbol(function).translate()
        );
    }
    
}