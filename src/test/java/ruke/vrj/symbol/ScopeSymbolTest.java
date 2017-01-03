package ruke.vrj.symbol;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.resolution.ChildParentResolution;

/**
 * Created by Ruke on 02/10/2016.
 */
public class ScopeSymbolTest {
    
    @Test
    public void resolutionStrategy() {
        Assert.assertTrue(new Symbol("").getResolution() instanceof ChildParentResolution);
    }
    
    @Test
    public void mustCheckVisibility() {
        ScopeSymbol lorem = new ScopeSymbol("lorem", null);
        
        Symbol a = new Symbol("a", null);
        Symbol b = new Symbol("b", null);
        
        b.setVisibility(Visibility.PRIVATE);
        
        try {
            lorem.define(a);
            lorem.define(b);
        } catch (Exception e) {}
        
        ScopeSymbol ipsum = new ScopeSymbol("ipsum", null);
        
        Assert.assertEquals(null, lorem.resolve(ipsum, "b"));
        Assert.assertEquals(b, lorem.resolve("b"));
    }
    
    @Test
    public void mustResolvePublicSymbols() {
        Symbol main = new StructSymbol("");
        
        Symbol a = new Symbol("a");
        
        Symbol someStruct = new ScopeSymbol("b");
        Symbol someMethod = new ScopeSymbol("c");
    
        someMethod.setVisibility(Visibility.PRIVATE);
        
        try {
            someStruct.define(someMethod);
    
            main.define(a);
            main.define(someStruct);
        } catch (Exception e) {}
        
        Assert.assertEquals(a, someMethod.resolve("a"));
    }
    
    @Test
    public void mustNotResolvePrivateSymbols() {
        Symbol main = new Symbol("");
        
        Symbol a = new ScopeSymbol("a");
        Symbol aChild = new Symbol("achild");
        
        Symbol b = new Symbol("b");
        
        aChild.setVisibility(Visibility.PRIVATE);
        
        try {
            a.define(aChild);
    
            main.define(a);
            main.define(b);
        } catch (Exception e) {}
        
        Assert.assertEquals(null, a.resolve(main, "achild"));
        Assert.assertEquals(null, a.resolve(b, "achild"));
        Assert.assertEquals(aChild, a.resolve(a, "achild"));
    }
    
    @Test
    public void mustAddParams() {
        ScopeSymbol a = new ScopeSymbol("a");
        Symbol b = new Symbol("b");
        
        try {
            a.defineParam(b);
        } catch (Exception e) {}
        
        Assert.assertTrue(a.getParams().contains(b));
    }
    
    @Test
    public void mustResolveParams() {
        ScopeSymbol a = new ScopeSymbol("a");
        Symbol b = new Symbol("b");
        
        try {
            a.defineParam(b);
        } catch (Exception e) {}
        
        Assert.assertEquals(b, a.resolve("b"));
    }
    
}