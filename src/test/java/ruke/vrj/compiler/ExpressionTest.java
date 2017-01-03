package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 24/12/2016.
 */
public class ExpressionTest {
    
    @Test
    public void checkCode() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local code c",
                "local integer i",
                "set c = function i",
                "set c = function foo",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "4:17 - i is not a function",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
    @Test
    public void checkLogicalExpression() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local boolean b",
                "set b = \"lorem\" or true",
                "set b = false or true",
                "set b = \"lorem\" and false",
                "set b = false and true",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(2, compiler.getAllErrors().size());
        Assert.assertEquals(
            "3:8 - \"lorem\" is not a boolean expression",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "5:8 - \"lorem\" is not a boolean expression",
            compiler.getAllErrors().get(1).getMessage()
        );
    }
    
    @Test
    public void checkComparisonExpression() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local boolean b",
                "set b = \"lorem\" == 1",
                "set b = true == false",
                "set b = \"lorem\" != 1",
                "set b = true != false",
                "set b = true < 1",
                "set b = 1 < 1",
                "set b = true > 1",
                "set b = 1 > 1",
                "set b = true >= 1",
                "set b = 1 >= 1",
                "set b = true <= 1",
                "set b = 1 <= 1",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(6, compiler.getAllErrors().size());
        Assert.assertEquals(
            "3:8 - Comparing two variables of different primitive types (expect real and integer) is not allowed",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "5:8 - Comparing two variables of different primitive types (expect real and integer) is not allowed",
            compiler.getAllErrors().get(1).getMessage()
        );
        Assert.assertEquals(
            "7:8 - Comparing the order/size of 2 variables only works on reals and integers",
            compiler.getAllErrors().get(2).getMessage()
        );
        Assert.assertEquals(
            "9:8 - Comparing the order/size of 2 variables only works on reals and integers",
            compiler.getAllErrors().get(3).getMessage()
        );
        Assert.assertEquals(
            "11:8 - Comparing the order/size of 2 variables only works on reals and integers",
            compiler.getAllErrors().get(4).getMessage()
        );
        Assert.assertEquals(
            "13:8 - Comparing the order/size of 2 variables only works on reals and integers",
            compiler.getAllErrors().get(5).getMessage()
        );
    }
    
    @Test
    public void useNumericInMathExpression() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local integer n",
                "set n = \"lorem\" % 2",
                "set n = 2 % 2.1",
                "set n = \"lorem\" / 1",
                "set n = 1.2 / 1",
                "set n = \"lorem\" * 2",
                "set n = 2 * 2.1",
                "set n = \"lorem\" + 2",
                "set n = 2.1 + 2",
                "set n = \"lorem\" - 1",
                "set n = 2.3 - 2",
            "endfunction"
        );
        
        Compiler compiler = new Compiler();
        compiler.compile(code);
        
        Assert.assertEquals(5, compiler.getAllErrors().size());
        Assert.assertEquals(
            "3:8 - \"lorem\" is not a numeric expression",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "5:8 - \"lorem\" is not a numeric expression",
            compiler.getAllErrors().get(1).getMessage()
        );
        Assert.assertEquals(
            "7:8 - \"lorem\" is not a numeric expression",
            compiler.getAllErrors().get(2).getMessage()
        );
        Assert.assertEquals(
            "9:8 - \"lorem\" is not a numeric expression",
            compiler.getAllErrors().get(3).getMessage()
        );
        Assert.assertEquals(
            "11:8 - \"lorem\" is not a numeric expression",
            compiler.getAllErrors().get(4).getMessage()
        );
    }
    
    @Test
    public void useNumericInNegativeExpression() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local integer n = -\"lorem\"",
                "local real e = -1",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "2:19 - \"lorem\" is not a numeric expression",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
    @Test
    public void useBooleanInNotExpression() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local boolean n = not \"lorem\"",
                "local boolean e = not true",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "2:22 - \"lorem\" is not a boolean expression",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
}
