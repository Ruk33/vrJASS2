package ruke.vrj.translator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 23/09/2016.
 */
public class IfStatementTest {
    
    @Test
    public void test() {
        Expression _if = new IfStatement();
        
        _if.append(new RawExpression("myCondition"));
        
        _if.append(new RawExpression("lorem"));
        _if.append(new RawExpression("ipsum"));
    
        _if.append(new ElseStatement().append(new RawExpression("dolor")));
        
        _if.append(new ElseIfStatement().append(new RawExpression("myOtherCondition")));
    
        Assert.assertEquals(
            "if myCondition then\n" +
                "lorem\n" +
                "ipsum\n" +
            "elseif myOtherCondition then\n" +
            "else\n" +
                "dolor\n" +
            "endif",
            _if.translate()
        );
    }
    
}