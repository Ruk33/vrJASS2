package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 18/12/2016.
 */
public class TypeTest {
    
    @Test
    public void checkAlreadyDefined() {
        String code = String.join("\n",
            "type buff extends integer",
            "type buff extends integer",
            "type bar extends integer"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "2:5 - Type buff is already defined",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
    @Test
    public void checkDefined() {
        String code = String.join("\n",
            "type lorem extends ipsum"
        );
        
        Compiler compiler = new Compiler();
        compiler.compile(code);
        
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "1:19 - ipsum is not defined",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
}
