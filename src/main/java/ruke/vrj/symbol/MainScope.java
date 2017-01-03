package ruke.vrj.symbol;

/**
 * Created by Ruke on 18/12/2016.
 */
public class MainScope extends ScopeSymbol {

  public MainScope() {
    super("", null);

    try {
      define(new Symbol("integer").setSymbolType(SymbolType.TYPE));
      define(new Symbol("real").setSymbolType(SymbolType.TYPE));
      define(new Symbol("boolean").setSymbolType(SymbolType.TYPE));
      define(new Symbol("string").setSymbolType(SymbolType.TYPE));
      define(new Symbol("code").setSymbolType(SymbolType.TYPE));
      define(new Symbol("nothing").setSymbolType(SymbolType.TYPE));
      define(new Symbol("null").setSymbolType(SymbolType.TYPE));
      define(new Symbol("handle").setSymbolType(SymbolType.TYPE));
    } catch (Exception e) {
    }
  }

  public void registerAlias(String name, Symbol symbol) {
    childs.put(name, symbol);
  }

}
