package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ParenthesisExpression extends Expression {

  private Expression expression;

  @Override
  public Expression append(Expression expression) {
    this.expression = expression;
    return super.append(expression);
  }

  @Override
  public String translate() {
    if (expression == null) {
      return "()";
    }
    return "(" + expression.translate() + ")";
  }

}
