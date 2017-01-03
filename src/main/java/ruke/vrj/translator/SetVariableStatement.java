package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class SetVariableStatement extends Expression {

  private Expression variable;
  private Expression value;

  @Override
  public Expression append(Expression expression) {
    if (variable == null) {
      variable = expression;
    } else {
      value = expression;
    }
    return super.append(expression);
  }

  @Override
  public String translate() {
    return "set " + variable.translate() + " = " + value.translate();
  }

}