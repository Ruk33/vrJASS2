package ruke.vrj.resolution;

import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 08/12/2016.
 */
public interface Resolution {
    
    Symbol resolve(Symbol requester, Symbol target, String name);
    
}
