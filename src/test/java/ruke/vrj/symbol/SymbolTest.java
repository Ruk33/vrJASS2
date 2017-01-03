package ruke.vrj.symbol;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.resolution.ChildParentResolution;

/**
 * Created by Ruke on 22/09/2016.
 */
public class SymbolTest {
    
    @Test
    public void resolutionStrategy() {
        Assert.assertTrue(new Symbol("").getResolution() instanceof ChildParentResolution);
    }
    
    @Test
    public void mustSetParentOnDefine() {
        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");
        
        try {
            a.define(b);
        } catch (Exception e) {}
        
        Assert.assertEquals(a, b.getParent());
    }
    
    @Test
    public void mustResolveFromChild() {
        ScopeSymbol main = new ScopeSymbol("main");
        ScopeSymbol a = new ScopeSymbol("a");
        ScopeSymbol b = new ScopeSymbol("b");
        Symbol c = new Symbol("c");
    
        try {
            main.define(a);
            a.define(b);
            b.define(c);
        } catch (Exception e) {}
    
        Assert.assertEquals(a, main.resolve("a"));
        Assert.assertEquals(b, a.resolve("b"));
        Assert.assertEquals(c, b.resolve("c"));
        Assert.assertEquals(a, b.resolve("a"));
        Assert.assertEquals(main, a.resolve("main"));
    }
    
}