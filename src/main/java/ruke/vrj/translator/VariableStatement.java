package ruke.vrj.translator;

import ruke.vrj.symbol.Modifier;

/**
 * Created by Ruke on 23/09/2016.
 */
public class VariableStatement extends Expression {
    
    private Expression value;
    
    public Expression getValue() {
        return value;
    }
    
    @Override
    public Expression append(Expression value) {
        this.value = value;
        return super.append(value);
    }
    
    @Override
    public String translate() {
        String type = getSymbol().getType().getName();
        String name = getSymbol().getName();
        
        String result = type + " " + name;
        
        if (value != null) {
            result += " = " + value.translate();
        }
        
        if (getSymbol().hasModifier(Modifier.LOCAL)) {
            result = "local " + result;
        }
        
        return result;
    }
    
}
