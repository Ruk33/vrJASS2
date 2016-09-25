package ruke.vrj.symbol;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

/**
 * Created by Ruke on 22/09/2016.
 */
public class FunctionSymbol extends Symbol {
    
    private ArrayList<Symbol> params;
    
    public FunctionSymbol(String name, Token token) {
        super(name, token);
        params = new ArrayList<>();
    }
    
    public FunctionSymbol(String name) {
        this(name, null);
    }
    
    public ArrayList<Symbol> getParams() {
        return params;
    }
    
    public FunctionSymbol defineParam(Symbol param) {
        params.add(param);
        define(param);
        return this;
    }
    
}
