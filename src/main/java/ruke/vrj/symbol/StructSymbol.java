package ruke.vrj.symbol;

import org.antlr.v4.runtime.Token;

/**
 * Created by Ruke on 02/10/2016.
 */
public class StructSymbol extends ScopeSymbol {
    
    protected StructInstanceSymbol scopeInstance;
    
    public StructSymbol(String name, Token token) {
        super(name, token);
        scopeInstance = new StructInstanceSymbol(this);
    }
    
    public StructSymbol(String name) {
        this(name, null);
    }
    
    @Override
    public Symbol getType() {
        return scopeInstance;
    }

    @Override
    public Symbol define(Symbol symbol) throws Exception {
        if (symbol.hasModifier(Modifier.STATIC)) {
            return super.define(symbol);
        }
        return scopeInstance.define(symbol);
    }

    @Override
    public Symbol resolve(Symbol requester, String name) {
        if ("thistype".equals(name) || getName().equals(name)) {
            return this;
        }
        
        if ("this".equals(name)) return scopeInstance;
        
        return getResolution().resolve(requester, this, name);
    }
}
