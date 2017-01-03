package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ModuloExpression extends Expression {

  private Expression a;
  private Expression b;

  @Override
  public Expression append(Expression expression) {
    if (a == null) {
      a = expression;
    } else {
      b = expression;
    }
    return super.append(expression);
  }

  @Override
  public String translate() {
    return "ModuloReal(" + a.translate() + ", " + b.translate() + ")";
  }

}
