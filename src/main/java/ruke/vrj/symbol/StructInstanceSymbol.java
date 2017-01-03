package ruke.vrj.symbol;

import ruke.vrj.resolution.NonStaticMemberResolution;

/**
 * Created by Ruke on 09/10/2016.
 */
public class StructInstanceSymbol extends ScopeSymbol {
    
    private StructSymbol struct;
    
    public StructInstanceSymbol(StructSymbol struct) {
        super("this", struct.getToken());
        this.struct = struct;
        setResolutionStrategy(new NonStaticMemberResolution());
    }

    @Override
    public Symbol resolve(Symbol requester, String name) {
        return getResolution().resolve(requester, this, name);
    }
}
