package ruke.vrj.translator;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ElseIfStatement extends IfStatement {

  @Override
  public String translate() {
    return String.format(
        "elseif %s then\n" +
            "%s",
        condition.translate(),
        body.translate()
    );
  }
}
