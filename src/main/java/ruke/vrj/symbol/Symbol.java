package ruke.vrj.symbol;

import org.antlr.v4.runtime.Token;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Ruke on 22/09/2016.
 */
public class Symbol {
    
    private Symbol parent;
    private String name;
    private Symbol type;
    private HashSet<Modifier> modifiers;
    private HashMap<String, Symbol> childs;
    private Token token;
    
    public Symbol(String name, Token token) {
        this.name = name;
        this.token = token;
        modifiers = new HashSet<>();
        childs = new HashMap<>();
    }
    
    public Symbol(String name) {
        this(name, null);
    }
    
    public Symbol getParent() {
        return parent;
    }
    
    public String getName() {
        return name;
    }
    
    public Symbol getType() {
        if (type == null) {
            return this;
        }
        
        return type;
    }
    
    public Symbol setType(Symbol type) {
        this.type = type;
        return this;
    }
    
    public Symbol addModifier(Modifier modifier) {
        modifiers.add(modifier);
        return this;
    }
    
    public boolean hasModifier(Modifier modifier) {
        return modifiers.contains(modifier);
    }
    
    public Collection<Symbol> getChilds() {
        return childs.values();
    }
    
    public Symbol define(Symbol symbol) {
        symbol.parent = this;
        this.childs.put(symbol.getName(), symbol);
        return this;
    }
    
    public Symbol resolve(String name) {
        if (this.getName().equals(name)) {
            return this;
        }
        
        Symbol resolved = this.childs.get(name);
        
        if (resolved == null && this.getParent() != null) {
            return this.getParent().resolve(name);
        }
        
        return resolved;
    }
    
    public Token getToken() {
        return token;
    }
}
