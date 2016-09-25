package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public interface StatementContainer {
    
    public boolean canDeclareVariables();
    
    public ArrayList<Symbol> getDeclaredVariables();
    
    public ArrayList<Expression> getChilds();
    
}
