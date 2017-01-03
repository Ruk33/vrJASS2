package ruke.vrj.validator;

import ruke.vrj.symbol.Symbol;
import ruke.vrj.symbol.SymbolType;

/**
 * Created by Ruke on 23/09/2016.
 */
public class Validator {

  TypeCompatible typeChecker = new TypeCompatible();

  public boolean isVariable(Symbol symbol) {
    return symbol.getSymbolType() == SymbolType.VARIABLE;
  }

  public boolean isStruct(Symbol symbol) {
    return symbol.getSymbolType() == SymbolType.STRUCT;
  }

  public boolean isNumber(Symbol symbol) {
    String type = symbol.getType().getName();
    return "integer".equals(type) || "real".equals(type);
  }

  public boolean isBoolean(Symbol symbol) {
    return "boolean".equals(symbol.getType().getName());
  }

  public boolean isFunction(Symbol symbol) {
    return symbol.getSymbolType() == SymbolType.FUNCTION;
  }

  public boolean isNull(Symbol symbol) {
    return "null".equals(symbol.getType().getName());
  }

  public boolean isValidType(Symbol symbol) {
    boolean isType = symbol.getSymbolType() == SymbolType.TYPE;
    boolean isStruct = symbol.getSymbolType() == SymbolType.STRUCT;

    return (isType || isStruct) && !this.isNull(symbol);
  }

  public boolean isTypeCompatible(Symbol a, Symbol b) {
    return typeChecker.compatible(a, b);
  }

}
