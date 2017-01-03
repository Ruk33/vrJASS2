package ruke.vrj.resolution;

import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 08/12/2016.
 */
public class MemberResolution implements Resolution {
    
    @Override
    public Symbol resolve(Symbol requester, Symbol target, String name) {
        Symbol resolved = target.getChildsByName().get(name);
    
        if (resolved != null && !resolved.canBeAccessBy(requester)) {
            resolved = null;
        }
        
        // TODO check in extends/implements
    
        return resolved;
    }
    
}
