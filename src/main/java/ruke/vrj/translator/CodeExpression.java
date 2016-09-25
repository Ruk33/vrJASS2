package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class CodeExpression extends Expression {
    
    @Override
    public String translate() {
        return "function " + getSymbol().getName();
    }
    
}
