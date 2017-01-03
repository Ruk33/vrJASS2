package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class FunctionStatement extends Expression {

  private Expression function;

  @Override
  public Expression append(Expression function) {
    this.function = function;
    return super.append(function);
  }

  @Override
  public String translate() {
    return "call " + function.translate();
  }

}