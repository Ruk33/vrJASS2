package ruke.vrj.resolution;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.Visibility;

/**
 * Created by Ruke on 09/12/2016.
 */
public class ChildResolutionTest {
    
    @Test
    public void resolve() {
        ScopeSymbol main = new ScopeSymbol("main");
        
        ScopeSymbol libraryA = new ScopeSymbol("a");
        ScopeSymbol functionFoo = new ScopeSymbol("foo");
        ScopeSymbol functionBar = new ScopeSymbol("bar");
        ScopeSymbol functionBaz = new ScopeSymbol("baz");
    
        functionFoo.setVisibility(Visibility.PRIVATE);
        
        try {
            libraryA.define(functionFoo).define(functionBar);
            main.define(libraryA).define(functionBaz);
        } catch (Exception e) {}
        
        Assert.assertEquals(functionBaz, libraryA.resolve("baz"));
        
        libraryA.setResolutionStrategy(new ChildResolution());
        Assert.assertEquals(null, libraryA.resolve("baz"));
        
        Assert.assertEquals(functionFoo, libraryA.resolve("foo"));
        Assert.assertEquals(functionBar, libraryA.resolve("bar"));
        
        Assert.assertEquals(functionBar, libraryA.resolve(functionBaz, "bar"));
        Assert.assertEquals(null, libraryA.resolve(functionBaz, "foo"));
    }
    
}