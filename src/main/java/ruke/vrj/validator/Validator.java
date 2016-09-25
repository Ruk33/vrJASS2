package ruke.vrj.validator;

import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 23/09/2016.
 */
public class Validator {
    
    TypeCompatible typeChecker = new TypeCompatible();
    
    public boolean isVariable(Symbol symbol) {
        return symbol.hasModifier(Modifier.VARIABLE);
    }
    
    public boolean isNumber(Symbol symbol) {
        String type = symbol.getType().getName();
        return "integer".equals(type) || "real".equals(type);
    }
    
    public boolean isBoolean(Symbol symbol) {
        return "boolean".equals(symbol.getType().getName());
    }
    
    public boolean isFunction(Symbol symbol) {
        return symbol.hasModifier(Modifier.FUNCTION);
    }
    
    public boolean isNull(Symbol symbol) {
        return "null".equals(symbol.getType().getName());
    }
    
    public boolean isValidType(Symbol symbol) {
        return symbol.hasModifier(Modifier.TYPE) && !this.isNull(symbol);
    }
    
    public boolean isTypeCompatible(Symbol a, Symbol b) {
        return typeChecker.compatible(a, b);
    }
    
}
