package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class RawExpression extends Expression {

  private String expression;

  public RawExpression(String expression) {
    this.expression = expression;
  }

  @Override
  public String translate() {
    return expression;
  }

}
