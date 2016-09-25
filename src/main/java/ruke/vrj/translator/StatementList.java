package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public class StatementList extends Expression implements StatementContainer {
    
    private ArrayList<Symbol> declarations = new ArrayList<Symbol>();
    private ArrayList<Expression> childs = new ArrayList<>();
    
    @Override
    public boolean canDeclareVariables() {
        if (getParent() instanceof StatementContainer) {
            return ((StatementContainer) getParent()).canDeclareVariables();
        }
        return false;
    }
    
    @Override
    public ArrayList<Symbol> getDeclaredVariables() {
        return declarations;
    }
    
    @Override
    public ArrayList<Expression> getChilds() {
        return childs;
    }
    
    private Expression tradeVariableDeclarationForAssignment(VariableStatement declaration) {
        if (declaration.getValue() == null) {
            return new RawExpression("");
        }
        
        SetVariableStatement assignment = new SetVariableStatement();
    
        assignment.setSymbol(declaration.getSymbol());
        
        assignment.append(new VariableExpression().setSymbol(declaration.getSymbol()));
        assignment.append(declaration.getValue());
        
        return assignment;
    }
    
    @Override
    public Expression append(Expression expression) {
        if (expression == null) {
            return this;
        }
        
        if (expression instanceof VariableStatement && !canDeclareVariables()) {
            declarations.add(expression.getSymbol());
            return append(
                tradeVariableDeclarationForAssignment((VariableStatement) expression)
            );
        }
        
        childs.add(expression);
        
        return super.append(expression);
    }
    
    @Override
    public String translate() {
        String result = "";
    
        for (Expression expr : childs) {
            result += expr.translate() + "\n";
        }
        
        return result.trim() + "\n";
    }
}