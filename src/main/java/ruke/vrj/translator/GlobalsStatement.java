package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public class GlobalsStatement extends Expression implements StatementContainer {

  private Expression body;

  public GlobalsStatement() {
    body = new StatementList().setParent(this);
  }

  @Override
  public boolean canDeclareVariables() {
    return true;
  }

  @Override
  public ArrayList<Symbol> getDeclaredVariables() {
    return ((StatementContainer) body).getDeclaredVariables();
  }

  @Override
  public ArrayList<Expression> getChilds() {
    return ((StatementContainer) body).getChilds();
  }

  @Override
  public Expression append(Expression expression) {
    body.append(expression);
    return this;
  }

  @Override
  public String translate() {
    return "globals\n" + body.translate() + "endglobals";
  }
}
