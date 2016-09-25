package ruke.vrj.translator;

import ruke.vrj.symbol.FunctionSymbol;
import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class FunctionDefinitionTest {
    
    @Test
    public void test() {
        FunctionSymbol foo = new FunctionSymbol("foo");
        
        foo.defineParam(new Symbol("bar").setType(new Symbol("baz")));
        foo.setType(new Symbol("integer"));
        
        Expression loop = new LoopStatement();
        
        loop.append(new RawExpression("some"));
        
        Symbol a = new Symbol("a");
        a.setType(new Symbol("someType"));
        
        loop.append(new VariableStatement().setSymbol(a).append(
            new RawExpression("someValue")
        ));
        
        Symbol b = new Symbol("b");
        b.setType(new Symbol("someOtherType"));
        
        loop.append(new VariableStatement().setSymbol(b));
    
        Assert.assertEquals(
            "function foo takes baz bar returns integer\n" +
                "someType a\n" +
                "someOtherType b\n" +
                "body\n" +
                "loop\n" +
                    "some\n" +
                    "set a = someValue\n" +
                "endloop\n" +
            "endfunction",
            new FunctionDefinition().setSymbol(foo).append(new RawExpression("body")).append(loop).translate()
        );
        
        
    }
    
}