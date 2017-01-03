package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class NegativeExpressionTest {

  @Test
  public void test() {
    Expression a = new RawExpression("a");

    Assert.assertEquals(
        "-a",
        new NegativeExpression().append(a).translate()
    );
  }

}