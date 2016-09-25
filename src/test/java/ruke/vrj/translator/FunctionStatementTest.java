package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class FunctionStatementTest {
    
    @Test
    public void test() {
        Symbol function = new Symbol("a");
        
        Expression expression = new FunctionExpression().setSymbol(function);
    
        Assert.assertEquals(
            "call a()",
            new FunctionStatement().append(expression).translate()
        );
    }
    
}