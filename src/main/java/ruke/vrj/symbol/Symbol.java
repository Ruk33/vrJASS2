package ruke.vrj.symbol;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
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
    private Visibility visibility;
    private HashSet<Modifier> modifiers;
    private HashMap<String, Symbol> childs;
    private HashMap<String, ArrayList<Symbol>> childsByFirstLetter;
    private Token token;
    
    public Symbol(String name, Token token) {
        this.name = name;
        this.token = token;
        modifiers = new HashSet<>();
        childs = new HashMap<>();
        childsByFirstLetter = new HashMap<>();
        
        setVisibility(Visibility.PUBLIC);
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
    
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
    
    public Visibility getVisibility() {
        return visibility;
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
    
    public ArrayList<Symbol> getChildsByFirstLetter(String letter) {
        ArrayList<Symbol> childs = childsByFirstLetter.get(letter.toLowerCase());
        
        if (childs == null) {
            childs = new ArrayList<>();
        }
        
        return childs;
    }
    
    private void addChildByLetter(Symbol symbol) {
        String firstLetter = symbol.getName().substring(0, 1).toLowerCase();
        
        if (!childsByFirstLetter.containsKey(firstLetter)) {
            childsByFirstLetter.put(firstLetter, new ArrayList<>());
        }
        
        childsByFirstLetter.get(firstLetter).add(symbol);
    }
    
    public Symbol define(Symbol symbol) {
        symbol.parent = this;
        
        childs.put(symbol.getName(), symbol);
        addChildByLetter(symbol);
        
        return this;
    }
    
    public Symbol resolve(Symbol requester, String name) {
        Symbol resolved = null;
        
        if (this.getName().equals(name)) {
            resolved = this;
        } else {
            resolved = this.childs.get(name);
        }
    
        if (resolved != null) {
            if (resolved.getVisibility() == Visibility.PUBLIC) {
                return resolved;
            } else if (resolved.getParent() == requester) {
                return resolved;
            }
            
            return null;
        }
        
        if (resolved == null && this.getParent() != null) {
            return this.getParent().resolve(name);
        }
    
        return resolved;
    }
    
    public Symbol resolve(String name) {
        return resolve(this, name);
    }
    
    public Token getToken() {
        return token;
    }
    
    public Symbol injectSymbol(Symbol symbol) {
        for (Symbol child : symbol.childs.values()) {
            define(child);
        }
        
        return this;
    }
}
