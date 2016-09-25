package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public class LoopStatement extends Expression implements StatementContainer {
    
    private Expression body;
    
    public LoopStatement() {
        body = new StatementList().setParent(this);
    }
    
    @Override
    public boolean canDeclareVariables() {
        return false;
    }
    
    @Override
    public ArrayList<Symbol> getDeclaredVariables() {
        return ((StatementList) body).getDeclaredVariables();
    }
    
    @Override
    public ArrayList<Expression> getChilds() {
        return ((StatementList) body).getChilds();
    }
    
    @Override
    public Expression append(Expression expression) {
        body.append(expression);
        return this;
    }
    
    @Override
    public String translate() {
        return "loop\n" + body.translate() + "endloop";
    }
    
}
