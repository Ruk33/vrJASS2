package ruke.vrj.validator;

import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 23/09/2016.
 */
public class TypeCompatible {
    
    private static final Boolean[][] compatibleTable = new Boolean[][] {
                 /* struct  int    real    bool    str     code    nothing null */
        /*struct*/  {true,  true,  false,  false,  false,  false,  false,  true},
        /*int*/     {true,  true,  true,   false,  false,  false,  false,  false},
        /*real*/    {false, true,  true,   false,  false,  false,  false,  false},
        /*bool*/    {false, false, false,  true,   false,  false,  false,  false},
        /*str*/     {false, false, false,  false,  true,   false,  false,  true},
        /*code*/    {false, false, false,  false,  false,  true,   false,  true},
        /*nothing*/ {false, false, false,  false,  false,  false,  true,   false},
        /*null*/    {true,  false, false,  false,  true,   true,   true,   true},
    };
    
    private int getIndex(Symbol symbol) {
        switch (symbol.getType().getName()) {
            case "integer": return 1;
            case "real": return 2;
            case "boolean": return 3;
            case "string": return 4;
            case "code": return 5;
            case "nothing": return 6;
            case "null": return 7;
        }
        
        return 0;
    }
    
    public boolean compatible(Symbol a, Symbol b) {
        if (a == null || b == null) return false;
        return compatibleTable[getIndex(a)][getIndex(b)];
    }
    
}
