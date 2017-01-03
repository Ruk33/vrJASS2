package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 24/12/2016.
 */
public class StructDefinitionTest {
    
    @Test
    public void operatorOverloading() {
        String code = String.join("\n",
            "struct foo",
                "method operator bar takes nothing returns integer",
                    "return 1",
                "endmethod",
                "static method operator bar takes nothing returns integer",
                    "return 2",
                "endmethod",
            "endstruct",
            "function baz takes nothing returns nothing",
                "local foo f",
                "local integer i = f.bar",
                "local integer e = foo.baz",
                "call f.bar()",
                "call foo.baz()",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
        
        System.out.print(compiler.getAllErrors().toString().replace(",", "\n"));
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "9:5 - f.bar() is not a function",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
    @Test
    public void integerAsInstance() {
        String code = String.join("\n",
            "struct foo",
            "endstruct",
            "function bar takes nothing returns nothing",
                "local foo f",
                "local integer fi = f",
                "set f = 2",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(0, compiler.getAllErrors().size());
    }
    
    @Test
    public void checkAlreadyDefined() {
        String code = String.join("\n",
            "struct foo",
            "endstruct",
            "struct foo",
            "endstruct"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(1, compiler.getAllErrors().size());
        Assert.assertEquals(
            "3:7 - Struct foo is already defined",
            compiler.getAllErrors().get(0).getMessage()
        );
    }
    
    @Test
    public void checkExtend() {
        String code = String.join("\n",
            "struct foo extends integer",
            "endstruct",
            "struct bar extends foo",
            "endstruct",
            "struct baz extends lorem",
            "endstruct",
            "struct e extends array",
            "endstruct"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(2, compiler.getAllErrors().size());
        Assert.assertEquals(
            "1:19 - Struct or 'array' expected",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "5:19 - lorem is not defined",
            compiler.getAllErrors().get(1).getMessage()
        );
    }
    
    @Test
    public void useNonStaticMembers() {
        String code = String.join("\n",
            "globals",
                "foo f",
            "endglobals",
            "struct foo",
                "method baz takes nothing returns thistype",
                    "return this",
                "endmethod",
                "method bar takes nothing returns nothing",
                    "call this.bar()",
                    "call bar()",
                    "call this.baz().baz().bar()",
                    "call foo.baz()",
                    "call thistype.bar()",
                    "call f.bar()",
                "endmethod",
            "endstruct"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(2, compiler.getAllErrors().size());
        Assert.assertEquals(
            "12:9 - baz is not defined",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "13:14 - bar is not defined",
            compiler.getAllErrors().get(1).getMessage()
        );
    }
    
    @Test
    public void useStaticMembers() {
        String code = String.join("\n",
            "globals",
                "foo f",
            "endglobals",
            "struct foo",
                "static method baz takes nothing returns nothing",
                "endmethod",
                "method bar takes nothing returns nothing",
                    "call baz()",
                    "call this.baz()",
                    "call f.baz()",
                    "call foo.baz()",
                    "call thistype.baz()",
                "endmethod",
            "endstruct"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
        
        Assert.assertEquals(2, compiler.getAllErrors().size());
        Assert.assertEquals(
            "9:10 - baz is not defined",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "10:7 - baz is not defined",
            compiler.getAllErrors().get(1).getMessage()
        );
    }
    
    @Test
    public void checkVisibility() {
        String code = String.join("\n",
            "struct foo",
                "integer a",
                "public integer b",
                "private integer c",
                "static integer d",
                "private static integer e",
            "endstruct",
            "function bar takes nothing returns nothing",
                "local foo f",
                "set f.a = 4",
                "set f.b = 5",
                "set f.c = 6",
                "set foo.d = 7",
                "set foo.e = 8",
            "endfunction"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        // TODO check consistency on error messages
        Assert.assertEquals(2, compiler.getAllErrors().size());
        Assert.assertEquals(
            "12:6 - c is not defined",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "14:8 - Scope bar cannot access member e",
            compiler.getAllErrors().get(1).getMessage()
        );
    }
    
    @Test
    public void checkCreateMethod() {
        String code = String.join("\n",
            "struct foo",
                "static method create takes nothing returns nothing",
                "endmethod",
            "endstruct",
            "struct bar",
                "method create takes nothing returns bar",
                    "local bar b",
                    "return b",
                "endmethod",
            "endstruct",
            "struct baz",
                "static method create takes nothing returns thistype",
                    "local thistype b",
                    "return b",
                "endmethod",
            "endstruct"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(2, compiler.getAllErrors().size());
        Assert.assertEquals(
            "2:14 - Method create must return foo",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "6:7 - Method create must be static",
            compiler.getAllErrors().get(1).getMessage()
        );
    }
    
    @Test
    public void checkOnInit() {
        String code = String.join("\n",
            "struct foo",
                "method onInit takes integer i returns nothing",
                "endmethod",
            "endstruct"
        );
    
        Compiler compiler = new Compiler();
        compiler.compile(code);
    
        Assert.assertEquals(2, compiler.getAllErrors().size());
        Assert.assertEquals(
            "2:7 - Initializers must not take any parameters",
            compiler.getAllErrors().get(0).getMessage()
        );
        Assert.assertEquals(
            "2:7 - Initializers must be static",
            compiler.getAllErrors().get(1).getMessage()
        );
    }
    
}
