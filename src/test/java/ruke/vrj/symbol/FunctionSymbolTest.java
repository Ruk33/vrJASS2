package ruke.vrj.symbol;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 22/09/2016.
 */
public class FunctionSymbolTest {
    
    @Test
    public void mustAddParams() {
        FunctionSymbol a = new FunctionSymbol("a");
        Symbol b = new Symbol("b");
    
        a.defineParam(b);
        
        Assert.assertTrue(a.getParams().contains(b));
    }
    
    @Test
    public void mustResolveParams() {
        FunctionSymbol a = new FunctionSymbol("a");
        Symbol b = new Symbol("b");
    
        a.defineParam(b);
    
        Assert.assertEquals(b, a.resolve("b"));
    }
    
}