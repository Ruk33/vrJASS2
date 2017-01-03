package ruke.vrj.symbol;

import org.junit.Assert;
import org.junit.Test;
import ruke.vrj.resolution.NonStaticMemberResolution;

/**
 * Created by Ruke on 10/12/2016.
 */
public class StructInstanceSymbolTest {
    
    @Test
    public void resolutionStrategy() {
        Assert.assertTrue(new StructSymbol("").getType().getResolution() instanceof NonStaticMemberResolution);
    }
    
}