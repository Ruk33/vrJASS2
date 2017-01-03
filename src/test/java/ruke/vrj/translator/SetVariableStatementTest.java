package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class SetVariableStatementTest {

  @Test
  public void test() {
    Expression variable = new RawExpression("foo");
    Expression value = new RawExpression("bar");

    Assert.assertEquals(
        "set foo = bar",
        new SetVariableStatement().append(variable).append(value).translate()
    );
  }

}