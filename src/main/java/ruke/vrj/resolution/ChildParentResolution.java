package ruke.vrj.resolution;

import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 08/12/2016.
 */
public class ChildParentResolution implements Resolution {

  @Override
  public Symbol resolve(Symbol requester, Symbol target, String name) {
    Symbol resolved;

    if (target.getName().equals(name)) {
      resolved = target;
    } else {
      resolved = target.getChildsByName().get(name);
    }

    if (resolved != null && !resolved.canBeAccessBy(requester)) {
      resolved = null;
    }

    if (resolved == null && target.getParent() != null) {
      resolved = target.getParent().resolve(requester, name);
    }

    return resolved;
  }

}
