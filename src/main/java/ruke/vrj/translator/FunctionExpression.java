package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class FunctionExpression extends Expression {
    
    private Expression params = new ExpressionList();
    
    @Override
    public Expression append(Expression params) {
        this.params = params;
        return super.append(params);
    }
    
    @Override
    public String translate() {
        return getSymbol().getName() + "(" + params.translate() + ")";
    }
    
}
