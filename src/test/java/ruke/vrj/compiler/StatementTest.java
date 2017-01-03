package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 26/12/2016.
 */
public class StatementTest {
    
    @Test
    public void checkElseIfCondition() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "if (true) then",
                "elseif (1) then",
                "endif",
                "if (true) then",
                "elseif (true) then",
                "endif",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "3:7 - (1) is not a boolean expression",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
        
    @Test
    public void checkIfCondition() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "if (1) then",
                "endif",
                "if (true) then",
                "endif",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "2:3 - (1) is not a boolean expression",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
    @Test
    public void checkExitwhenCondition() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "loop",
                    "exitwhen 1",
                    "exitwhen true",
                "endloop",
            "endfunction"
        );
        
        Compiler compiler = new Compiler();
        compiler.compile(code);
        
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "3:9 - 1 is not a boolean expression",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
}
