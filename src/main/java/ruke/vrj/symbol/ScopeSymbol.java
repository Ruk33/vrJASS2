package ruke.vrj.symbol;

import org.antlr.v4.runtime.Token;

/**
 * Created by Ruke on 02/10/2016.
 */
public class ScopeSymbol extends Symbol {
    
    protected Symbol initializer;
    
    public ScopeSymbol(String name, Token token) {
        super(name, token);
    }
    
    public Symbol getInitializer() {
        return initializer;
    }
    
    public ScopeSymbol defineInitializer(Symbol initializer) {
        this.initializer = initializer;
        define(initializer);
        return this;
    }
    
}
