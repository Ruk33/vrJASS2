package ruke.vrj.resolution;

import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 08/12/2016.
 */
public class StaticMemberResolution implements Resolution {

  @Override
  public Symbol resolve(Symbol requester, Symbol target, String name) {
    Symbol resolved = new MemberResolution().resolve(requester, target, name);

    if (resolved != null && !resolved.hasModifier(Modifier.STATIC)) {
      resolved = null;
    }

    return resolved;
  }

}
