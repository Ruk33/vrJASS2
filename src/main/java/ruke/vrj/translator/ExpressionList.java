package ruke.vrj.translator;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ExpressionList extends Expression {
    
    private ArrayList<Expression> childs = new ArrayList<>();
    
    @Override
    public Expression append(Expression expression) {
        childs.add(expression);
        return super.append(expression);
    }
    
    @Override
    public String translate() {
        ArrayList<String> result = new ArrayList<>();
        
        for (Expression expr : childs) {
            result.add(expr.translate());
        }
        
        return String.join(", ", result);
    }
    
}
