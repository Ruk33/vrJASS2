package ruke.vrj.translator;

import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public class FunctionDefinition extends Expression implements StatementContainer {

  private Expression declarations;
  private Expression body;

  public FunctionDefinition() {
    declarations = new StatementList().setParent(this);
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

  private Expression getParams() {
    Expression result = new ExpressionList();

    if (getSymbol() instanceof ScopeSymbol) {
      ArrayList<Symbol> params = ((ScopeSymbol) getSymbol()).getParams();

      if (params.isEmpty()) {
        result.append(new RawExpression("nothing"));
      } else {
        for (Symbol param : params) {
          result.append(new ParamExpression().setSymbol(param));
        }
      }
    }

    return result;
  }

  private Expression declareVariables(StatementContainer body) {
    for (Symbol variable : body.getDeclaredVariables()) {
      append(new VariableStatement().setSymbol(variable));
    }

    for (Expression expression : body.getChilds()) {
      if (expression instanceof StatementContainer) {
        declareVariables((StatementContainer) expression);
      }
    }

    return this;
  }

  @Override
  public Expression append(Expression expression) {
    if (expression instanceof StatementContainer) {
      declareVariables((StatementContainer) expression);
    }

    if (expression instanceof VariableStatement) {
      declarations.append(expression);
    } else {
      body.append(expression);
    }

    return this;
  }

  @Override
  public String translate() {
    return String.format(
        "function %s takes %s returns %s\n" +
            "%s" +
            "%s" +
            "endfunction",
        getSymbol().getName(),
        getParams().translate(),
        getSymbol().getType().getName(),
        declarations.translate(),
        body.translate()
    );
  }
}
