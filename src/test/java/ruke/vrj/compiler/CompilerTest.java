package ruke.vrj.compiler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class CompilerTest {
    
    private static Compiler compile(String code) {
        Compiler compiler = new Compiler();
        compiler.compile(new ANTLRInputStream(code + "\n"));
        return compiler;
    }
    
    private static String translate(String code) {
        return new Compiler().compile(new ANTLRInputStream(code + "\n"));
    }
    
    @Test
    @Ignore
    public void mustTranslate() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local integer i = 42",
                "if i then",
                    "local real r = 44",
                    "call foo()",
                "endif",
                "return i",
            "endfunction",
            "globals",
                "real pii = 3.14",
            "endglobals"
        );
        
        Assert.assertEquals(
            String.join("\n",
                "globals",
                    "real pii = 3.14",
                "endglobals",
                "function foo takes nothing returns nothing",
                    "local integer i",
                    "local real r",
                    "set i = 42",
                    "if i then",
                        "set r = 44",
                        "call foo()",
                    "endif",
                    "return i",
                "endfunction"
            ),
            translate(code));
    }
    
    @Test
    public void mustDetectAlreadyDefined() {
        String code = String.join("\n",
            "globals",
                "real pi = 3.14",
                "real pi = 14.3",
            "endglobals"
        );
    
        Compiler compiler = compile(code);
    
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "3:0 - Variable pi is already defined"
        );
    }
    
    @Test
    public void mustDetectUndefined() {
        String code = String.join("\n",
            "globals",
                "real pi = pi2",
            "endglobals"
        );
        
        Compiler compiler = compile(code);
        
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "2:10 - Incompatible type. Expected real but nothing given"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(1).getMessage(),
            "2:10 - pi2 is not a variable"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(2).getMessage(),
            "2:10 - pi2 is not defined"
        );
    }
    
    @Test
    public void mustDetectTypeCompatibility() {
        String code = String.join("\n",
            "globals",
                "real pi = true",
            "endglobals"
        );
    
        Compiler compiler = compile(code);
    
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "2:10 - Incompatible type. Expected real but boolean given"
        );
    }
    
    @Test
    public void mustDetectNonFunctions() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "call real()",
            "endfunction"
        );
    
        Compiler compiler = compile(code);
    
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "2:5 - real is not a function"
        );
    }
    
    @Test
    public void mustDetectValidType() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local foo bar",
            "endfunction"
        );
    
        Compiler compiler = compile(code);
    
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "2:6 - foo is not a valid type"
        );
    }
    
    @Test
    public void mustCheckForNumericExpression() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local integer i",
                "set i = true - 5",
                "set i = i + 5",
                "set i = 1 % null",
                "set i = false / foo",
            "endfunction"
        );
    
        Compiler compiler = compile(code);
    
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "5:12 - null is not a numeric expression"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(1).getMessage(),
            "6:8 - false is not a numeric expression"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(2).getMessage(),
            "3:8 - true is not a numeric expression"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(3).getMessage(),
            "6:16 - foo is not a variable"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(4).getMessage(),
            "6:16 - foo is not a numeric expression"
        );
    }
    
    @Test
    public void mustCheckBooleanExpression() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "local boolean bar",
                "set bar = 1 or 2 and null",
                "set bar = false or true",
                "set bar = null and false",
            "endfunction"
        );
    
        Compiler compiler = compile(code);
    
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "3:21 - null is not a boolean expression"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(1).getMessage(),
            "3:15 - 2 is not a boolean expression"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(2).getMessage(),
            "5:10 - null is not a boolean expression"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(3).getMessage(),
            "3:10 - 1 is not a boolean expression"
        );
    }
    
    @Test
    public void mustCheckConditionals() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
                "if 1 then",
                "elseif true then",
                "elseif null then",
                "else",
                "endif",
                "loop",
                    "exitwhen 1",
                    "exitwhen true",
                "endloop",
            "endfunction"
        );
        
        Compiler compiler = compile(code);
        
        Assert.assertEquals(
            "2:3 - 1 is not a boolean expression",
            compiler.getAllErrors().get(0).getMessage()
        );
    
        Assert.assertEquals(
            "8:9 - 1 is not a boolean expression",
            compiler.getAllErrors().get(1).getMessage()
        );
    
        Assert.assertEquals(
            "4:7 - null is not a boolean expression",
            compiler.getAllErrors().get(2).getMessage()
        );
    }
    
    @Test
    public void mustCheckParams() {
        String code = String.join("\n",
            "function foo takes nothing returns nothing",
            "endfunction",
            "function bar takes integer a, boolean b returns nothing",
            "endfunction",
            "function baz takes nothing returns nothing",
                "call foo()",
                "call foo(1, 2)",
                "call bar()",
                "call bar(true, 1)",
                "call bar(1, false)",
            "endfunction"
        );
    
        Compiler compiler = compile(code);
    
        Assert.assertEquals(
            compiler.getAllErrors().get(0).getMessage(),
            "8:5 - Incorrect argument count. Expected 2 arguments"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(1).getMessage(),
            "9:9 - Incompatible type. Expected integer but boolean given"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(2).getMessage(),
            "9:15 - Incompatible type. Expected boolean but integer given"
        );
    
        Assert.assertEquals(
            compiler.getAllErrors().get(3).getMessage(),
            "7:5 - Incorrect argument count. Expected 0 arguments"
        );
    }
    
}