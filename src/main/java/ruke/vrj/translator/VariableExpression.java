package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class VariableExpression extends Expression {
    
    private Expression index;
    
    @Override
    public Expression append(Expression index) {
        this.index = index;
        return super.append(index);
    }
    
    @Override
    public String translate() {
        if (index == null) {
            return getSymbol().getName();
        }
        
        return getSymbol().getName() + index.translate();
    }
    
}
