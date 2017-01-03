package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class LoopStatementTest {

  @Test
  public void test() {
    Expression a = new RawExpression("a");
    Expression b = new RawExpression("b");

    Assert.assertEquals(
        "loop\n" +
            "a\n" +
            "b\n" +
            "endloop",
        new LoopStatement().append(a).append(b).translate()
    );
  }

}