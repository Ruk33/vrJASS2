package ruke.vrj.symbol;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Ruke on 02/10/2016.
 */
public class ScopeSymbol extends Symbol {

  protected Symbol initializer;
  protected ArrayList<Symbol> params;
  protected HashMap<String, Symbol> childs;

  public ScopeSymbol(String name, Token token) {
    super(name, token);

    params = new ArrayList<>();
    childs = new HashMap<>();
  }

  public ScopeSymbol(String name) {
    this(name, null);
  }

  public Symbol getInitializer() {
    return initializer;
  }

  public ScopeSymbol setInitializer(Symbol initializer) {
    this.initializer = initializer;
    return this;
  }

  public ArrayList<Symbol> getParams() {
    return params;
  }

  public ScopeSymbol defineParam(Symbol param) throws Exception {
    define(param);
    params.add(param);
    return this;
  }

  @Override
  public Symbol define(Symbol symbol) throws Exception {
    if (childs.containsKey(symbol.getName())) {
      throw new Exception("Already defined");
    }

    // Add compatibility to vJASS
    if (getSymbolType() == SymbolType.LIBRARY) {
      Symbol main = this;

      while (main.getParent() != null) {
        main = main.getParent();
      }

      String alias = String.format("%s_%s", getName(), symbol.getName());

      if (main instanceof MainScope) {
        ((MainScope) main).registerAlias(alias, symbol);
      }
    }

    childs.put(symbol.getName(), symbol);
    return super.define(symbol);
  }

  @Override
  public Collection<Symbol> getChilds() {
    return childs.values();
  }

  @Override
  public HashMap<String, Symbol> getChildsByName() {
    return childs;
  }

  @Override
  public Symbol resolve(Symbol requester, String name) {
    return getResolution().resolve(requester, this, name);
  }
}
