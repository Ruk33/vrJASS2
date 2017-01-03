package ruke.vrj.symbol;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.resolution.ChildParentResolution;

/**
 * Created by Ruke on 08/10/2016.
 */
public class StructSymbolTest {
    
    @Test
    public void resolutionStrategy() {
        Assert.assertTrue(new StructSymbol("").getResolution() instanceof ChildParentResolution);
    }
    
    @Test
    public void mustResolveThistype() {
        StructSymbol a = new StructSymbol("a");
        Assert.assertNotEquals(null, a.resolve("thistype"));
        Assert.assertEquals(a, a.resolve("thistype"));
    }
    
    @Test
    public void mustNotResolveStaticMembersFromInstance() {
        ScopeSymbol library = new ScopeSymbol("library", null);
        
        ScopeSymbol struct = new StructSymbol("foo", null);
        struct.setSymbolType(SymbolType.STRUCT);
        
        ScopeSymbol a = new ScopeSymbol("a", null);
        a.addModifier(Modifier.STATIC);
        
        ScopeSymbol b = new ScopeSymbol("b", null);
        
        try {
            struct.define(a);
            struct.define(b);
        } catch (Exception e) {}
        
        Symbol instance = new Symbol("bar", null);
        instance.setType(struct.getType());
        
        try {
            library.define(new Symbol("integer"));
            library.define(struct);
        } catch (Exception e) {}
        
        Assert.assertEquals(null, instance.resolve("a"));
        Assert.assertEquals(b, instance.resolve("b"));
        Assert.assertEquals(null, instance.resolve("integer"));
        Assert.assertNotEquals(null, struct.resolve("integer"));
    }
    
}