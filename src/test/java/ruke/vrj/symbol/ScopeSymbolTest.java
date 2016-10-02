package ruke.vrj.symbol;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 02/10/2016.
 */
public class ScopeSymbolTest {
    
    @Test
    public void mustCheckVisibility() {
        ScopeSymbol lorem = new ScopeSymbol("lorem", null);
        
        Symbol a = new Symbol("a", null);
        Symbol b = new Symbol("b", null);
        
        b.setVisibility(Visibility.PRIVATE);
        
        lorem.define(a);
        lorem.define(b);
        
        ScopeSymbol ipsum = new ScopeSymbol("ipsum", null);
        
        Assert.assertEquals(null, lorem.resolve(ipsum, "b"));
        Assert.assertEquals(b, lorem.resolve("b"));
    }
    
}