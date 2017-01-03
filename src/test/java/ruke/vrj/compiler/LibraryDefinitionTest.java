package ruke.vrj.compiler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 18/12/2016.
 */
public class LibraryDefinitionTest {

  @Test
  public void checkAlreadyDefined() {
    String code = String.join("\n",
        "library foo",
        "endlibrary",
        "library foo",
        "endlibrary",
        "library bar",
        "endlibrary"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "3:8 - Library foo is already defined",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

  @Test
  public void checkDefinedRequirements() {
    String code = String.join("\n",
        "library foo requires bar, foo, lorem, integer",
        "endlibrary",
        "library bar",
        "endlibrary"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(2, compiler.getAllErrors().size());
    Assert.assertEquals(
        "1:31 - lorem is not defined",
        compiler.getAllErrors().get(0).getMessage()
    );
    Assert.assertEquals(
        "1:38 - integer is not a library",
        compiler.getAllErrors().get(1).getMessage()
    );
  }

  @Test
  public void checkInitializer() {
    String code = String.join("\n",
        "library foo initializer init",
        "function init takes integer i returns nothing",
        "endfunction",
        "endlibrary",
        "library bar initializer lorem",
        "endlibrary",
        "library ipsum initializer init",
        "function init takes nothing returns nothing",
        "endfunction",
        "endlibrary",
        "library dolor initializer integer",
        "endlibrary"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(3, compiler.getAllErrors().size());
    Assert.assertEquals(
        "1:24 - Initializers must not take any parameters",
        compiler.getAllErrors().get(0).getMessage()
    );
    Assert.assertEquals(
        "5:24 - lorem is not defined",
        compiler.getAllErrors().get(1).getMessage()
    );
    Assert.assertEquals(
        "11:26 - integer is not a function",
        compiler.getAllErrors().get(2).getMessage()
    );
  }

  @Test
  public void checkVisibility() {
    String code = String.join("\n",
        "library foo",
        "public function bar takes nothing returns nothing",
        "call bar()",
        "call foo_bar()",
        "endfunction",
        "function baz takes nothing returns nothing",
        "endfunction",
        "private function ipsum takes nothing returns nothing",
        "endfunction",
        "endlibrary",
        "function ipsum takes nothing returns nothing",
        "endfunction",
        "function lorem takes nothing returns nothing",
        "call foo_bar()",
        "call foo.bar()",
        "call foo.baz()",
        "call foo.ipsum()",
        "call foo.lorem()",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(2, compiler.getAllErrors().size());
    Assert.assertEquals(
        "17:9 - Scope lorem cannot access member ipsum",
        compiler.getAllErrors().get(0).getMessage()
    );
    Assert.assertEquals(
        "18:9 - lorem is not defined",
        compiler.getAllErrors().get(1).getMessage()
    );
  }

  @Test
  public void checkVisibilityOnGlobals() {
    String code = String.join("\n",
        "library foo",
        "globals",
        "private integer i = 42",
        "public integer e = 32",
        "integer a = 22",
        "endglobals",
        "public function bar takes nothing returns nothing",
        "set i = 42",
        "set e = 32",
        "set a = 22",
        "set foo_e = 32",
        "set foo.i = 42",
        "endfunction",
        "endlibrary",
        "function lorem takes nothing returns nothing",
        "set foo.i = 2",
        "set foo.e = 4",
        "set foo.a = 3",
        "set foo_e = 4",
        "endfunction"
    );

    Compiler compiler = new Compiler();
    compiler.compile(code);

    Assert.assertEquals(1, compiler.getAllErrors().size());
    Assert.assertEquals(
        "16:8 - Scope lorem cannot access member i",
        compiler.getAllErrors().get(0).getMessage()
    );
  }

}
