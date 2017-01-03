package ruke.vrj.resolution;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 09/12/2016.
 */
public class ChildParentResolutionTest {

  @Test
  public void resolve() {
    ScopeSymbol libraryA = new ScopeSymbol("a");

    Symbol typeInteger = new Symbol("integer");

    ScopeSymbol functionFoo = new ScopeSymbol("foo");
    ScopeSymbol functionBar = new ScopeSymbol("bar");
    Symbol variableBaz = new Symbol("baz");

    try {
      functionFoo.define(variableBaz);
      libraryA.define(typeInteger).define(functionFoo).define(functionBar);
    } catch (Exception e) {
    }

    Assert.assertEquals(typeInteger, functionBar.resolve("integer"));
    Assert.assertEquals(null, functionBar.resolve("baz"));
    Assert.assertEquals(null, libraryA.resolve("baz"));
    Assert.assertEquals(variableBaz, functionFoo.resolve("baz"));
    Assert.assertEquals(typeInteger, libraryA.resolve("integer"));
  }

}