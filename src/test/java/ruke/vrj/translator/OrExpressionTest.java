package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class OrExpressionTest {
    
    @Test
    public void test() {
        Expression a = new RawExpression("a");
        Expression b = new RawExpression("b");
        
        Assert.assertEquals(
            "a or b",
            new OrExpression().append(a).append(b).translate()
        );
    }
    
}