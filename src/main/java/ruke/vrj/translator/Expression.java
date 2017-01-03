package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 23/09/2016.
 */
public abstract class Expression {

  protected Symbol symbol;
  protected Expression parent;

  public Expression setSymbol(Symbol symbol) {
    this.symbol = symbol;
    return this;
  }

  public Symbol getSymbol() {
    if (symbol != null) {
      return symbol;
    }

    if (getParent() != null) {
      return getParent().getSymbol();
    }

    return null;
  }

  public Expression setParent(Expression parent) {
    this.parent = parent;
    return this;
  }

  public Expression getParent() {
    return parent;
  }

  public Expression append(Expression expression) {
    expression.setParent(this);
    return this;
  }

  public abstract String translate();

}
