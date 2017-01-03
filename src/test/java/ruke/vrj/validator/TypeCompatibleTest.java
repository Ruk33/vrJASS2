package ruke.vrj.validator;

import ruke.vrj.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class TypeCompatibleTest {

  @Test
  public void test() {
    TypeCompatible checker = new TypeCompatible();

    Symbol integer = new Symbol("integer");
    Symbol real = new Symbol("real");
    Symbol bool = new Symbol("boolean");
    Symbol string = new Symbol("string");
    Symbol code = new Symbol("code");
    Symbol nothing = new Symbol("nothing");
    Symbol _null = new Symbol("null");

    Assert.assertTrue(checker.compatible(integer, real));
    Assert.assertTrue(checker.compatible(real, integer));
    Assert.assertFalse(checker.compatible(integer, string));
    Assert.assertTrue(checker.compatible(string, _null));
    Assert.assertFalse(checker.compatible(bool, code));
    Assert.assertTrue(checker.compatible(nothing, nothing));
  }

}