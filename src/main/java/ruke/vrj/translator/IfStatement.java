package ruke.vrj.translator;

import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public class IfStatement extends Expression implements StatementContainer {

  protected Expression condition;
  protected Expression body;
  protected Expression _else;

  public IfStatement() {
    body = new StatementList().setParent(this);
  }

  @Override
  public boolean canDeclareVariables() {
    return false;
  }

  @Override
  public ArrayList<Symbol> getDeclaredVariables() {
    return ((StatementList) body).getDeclaredVariables();
  }

  @Override
  public ArrayList<Expression> getChilds() {
    return ((StatementList) body).getChilds();
  }

  @Override
  public Expression append(Expression expression) {
    if (condition == null) {
      condition = expression;
    } else if (expression instanceof ElseStatement) {
      _else = expression;
    } else {
      body.append(expression);
      return this;
    }

    return super.append(expression);
  }

  @Override
  public String translate() {
    return String.format(
        "if %s then\n" +
            "%s" +
            "%s" +
            "endif",
        condition.translate(),
        body.translate(),
        _else == null ? "" : _else.translate()
    );
  }
}
