package ruke.vrj.resolution;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.StructSymbol;

/**
 * Created by Ruke on 09/12/2016.
 */
public class NonStaticMemberResolutionTest {
    @Test
    public void resolve() {
        StructSymbol struct = new StructSymbol("struct");
    
        ScopeSymbol staticMethodFoo = new ScopeSymbol("foo");
        ScopeSymbol methodBar = new ScopeSymbol("bar");
        
        staticMethodFoo.addModifier(Modifier.STATIC);
        try {
            struct.define(staticMethodFoo).define(methodBar);
        } catch (Exception e) {}
        
        Assert.assertEquals(methodBar, struct.getType().resolve("bar"));
        Assert.assertEquals(null, struct.getType().resolve("foo"));
    }
    
}