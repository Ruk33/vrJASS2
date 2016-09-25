package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class BracketExpressionTest {
    
    @Test
    public void test() {
        RawExpression a = new RawExpression("1");
        Assert.assertEquals("[1]", new BracketExpression().append(a).translate());
    }
    
}