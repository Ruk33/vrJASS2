package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ReturnStatement extends Expression {

  private Expression value;

  @Override
  public Expression append(Expression value) {
    this.value = value;
    return super.append(value);
  }

  @Override
  public String translate() {
    if (value == null) {
      return "return";
    }

    return "return " + value.translate();
  }

}