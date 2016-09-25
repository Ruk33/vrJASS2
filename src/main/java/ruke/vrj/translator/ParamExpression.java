package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ParamExpression extends Expression {
    
    @Override
    public String translate() {
        String type = getSymbol().getType().getName();
        
        if ("nothing".equals(type)) {
            return type;
        }
        
        return type + " " + getSymbol().getName();
    }
    
}
