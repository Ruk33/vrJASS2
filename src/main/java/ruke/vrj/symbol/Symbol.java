package ruke.vrj.symbol;

import org.antlr.v4.runtime.Token;
import ruke.vrj.resolution.ChildParentResolution;
import ruke.vrj.resolution.Resolution;

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

  private Symbol cachedType;
  private HashSet<Symbol> _extends;
  private SymbolType symbolType;
  private Visibility visibility;
  private HashSet<Modifier> modifiers;
  private Resolution resolution;
  private Token token;

  public Symbol(String name, Token token) {
    this.name = name;
    this.token = token;
    _extends = new HashSet<>();
    modifiers = new HashSet<>();

    setVisibility(Visibility.PUBLIC);
    setResolutionStrategy(new ChildParentResolution());
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
    if (cachedType == null) {
      return this;
    }

    return cachedType;
  }

  public Symbol setType(Symbol type) {
    if (type != null) {
      this.cachedType = type.getType();
    }

    return this;
  }

  public Symbol addExtends(Symbol symbol) {
    _extends.add(symbol);
    return this;
  }

  public HashSet<Symbol> getExtends() {
    return _extends;
  }

  public Symbol setSymbolType(SymbolType symbolType) {
    this.symbolType = symbolType;
    return this;
  }

  public SymbolType getSymbolType() {
    return symbolType;
  }

  public Symbol setVisibility(Visibility visibility) {
    this.visibility = visibility;
    return this;
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
    return new ArrayList<>();
  }

  public HashMap<String, Symbol> getChildsByName() {
    return new HashMap<>();
  }

  public ArrayList<Symbol> getChildsByFirstLetter(String letter) {
        /*ArrayList<Symbol> childs = childsByFirstLetter.get(letter.toLowerCase());
        
        if (childs == null) {
            childs = new ArrayList<>();
        }
        
        return childs;*/

    return new ArrayList<>();
  }

  private void addChildByLetter(Symbol symbol) {
        /*String firstLetter = symbol.getName().substring(0, 1).toLowerCase();
        
        if (!childsByFirstLetter.containsKey(firstLetter)) {
            childsByFirstLetter.put(firstLetter, new ArrayList<>());
        }
        
        childsByFirstLetter.get(firstLetter).add(symbol);*/
  }

  public Symbol define(Symbol symbol) throws Exception {
    symbol.parent = this;
    return this;
  }

  public Symbol resolve(Symbol requester, String name) {
    if (getType() != this) {
      return getType().resolve(requester, name);
    }

    return getResolution().resolve(requester, this, name);
  }

  public Symbol resolve(String name) {
    return resolve(this, name);
  }

  public Symbol setResolutionStrategy(Resolution resolution) {
    this.resolution = resolution;
    return this;
  }

  public Resolution getResolution() {
    return resolution;
  }

  public Token getToken() {
    return token;
  }

  public boolean canBeAccessBy(Symbol whichSymbol) {
    if (getVisibility() == Visibility.PUBLIC) {
      return true;
    }

    return getParent() == whichSymbol || getParent() == whichSymbol.getParent();
  }

  public Symbol injectSymbol(Symbol symbol) {
        /*for (Symbol child : symbol.childs.values()) {
            define(child);
        }*/

    return this;
  }

}
