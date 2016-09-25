package ruke.vrj.symbol;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 22/09/2016.
 */
public class SymbolTest {
    
    @Test
    public void mustSetParentOnDefine() {
        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");
        
        a.define(b);
        
        Assert.assertEquals(a, b.getParent());
    }
    
    @Test
    public void mustBeChildOnDefine() {
        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");
    
        a.define(b);
    
        Assert.assertEquals(true, a.getChilds().contains(b));
    }
    
    @Test
    public void mustResolveFromChild() {
        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");
        Symbol c = new Symbol("c");
        Symbol d = null;
    
        b.define(c);
        a.define(b);
    
        Assert.assertEquals(a, c.resolve("a"));
        Assert.assertEquals(b, c.resolve("b"));
        Assert.assertEquals(c, c.resolve("c"));
        Assert.assertEquals(d, c.resolve("d"));
    }
    
}