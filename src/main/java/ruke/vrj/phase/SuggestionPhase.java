package ruke.vrj.phase;

import org.antlr.v4.runtime.ParserRuleContext;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.symbol.FunctionSymbol;
import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.Symbol;
import ruke.vrj.validator.TypeCompatible;

import java.util.ArrayList;

/**
 * Created by Ruke on 25/09/2016.
 */
public class SuggestionPhase extends BasePhase {
    
    private ArrayList<Symbol> suggestions;
    private TypeCompatible typeCompatible;
    private int line;
    private int _char;
    
    public SuggestionPhase(Symbol scope, int line, int _char) {
        super(scope);
        
        suggestions = new ArrayList<>();
        typeCompatible = new TypeCompatible();
        
        this.line = line;
        this._char = _char;
    }
    
    public ArrayList<Symbol> getSuggestions() {
        return suggestions;
    }
    
    private boolean inCursorLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine() == line;
    }
    
    private void fillSuggestions(Modifier modifier, Symbol type) {
        if (!suggestions.isEmpty()) {
            return;
        }
        
        Symbol parent = scope;
        
        while (parent != null) {
            for (Symbol child : parent.getChilds()) {
                if (modifier != null && !child.hasModifier(modifier)) {
                    continue;
                }
                
                if (type != null) {
                    if (child.hasModifier(Modifier.TYPE)) continue;
                    if (type == child) continue;
                    if (!typeCompatible.compatible(type, child)) continue;
                }
    
                suggestions.add(child);
            }
            
            parent = parent.getParent();
        }
    }
    
    @Override
    public Symbol visitType(vrjParser.TypeContext ctx) {
        if (!inCursorLine(ctx)) {
            return null;
        }
    
        fillSuggestions(Modifier.TYPE, null);
    
        return null;
    }
    
    @Override
    public Symbol visitFunctionExpression(vrjParser.FunctionExpressionContext ctx) {
        if (inCursorLine(ctx)) {
            if (ctx.name().getText().isEmpty()) {
                fillSuggestions(Modifier.FUNCTION, null);
                return null;
            }
    
            Symbol function = symbols.get(symbols.getToken(ctx));
    
            if (function instanceof FunctionSymbol) {
                ArrayList<Symbol> params = ((FunctionSymbol) function).getParams();
                
                if (ctx.expressionList() == null) {
                    fillSuggestions(null, params.get(0));
                } else {
                    int paramIndex = 0;
                    boolean found = false;
                    
                    for (vrjParser.ExpressionContext expr : ctx.expressionList().expression()) {
                        if (expr.getStart().getCharPositionInLine() == _char) {
                            found = true;
                            break;
                        }
    
                        paramIndex++;
                    }
    
                    if (found && paramIndex <= params.size() - 1) {
                        fillSuggestions(null, params.get(paramIndex));
                    }
                }
            }
        }
    
        return super.visitFunctionExpression(ctx);
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        if (ctx.expression() != null && inCursorLine(ctx.expression())) {
            fillSuggestions(null, symbols.get(symbols.getToken(ctx)));
        }
        return super.visitVariableStatement(ctx);
    }
    
    @Override
    public Symbol visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx) {
        Symbol function = symbols.get(symbols.getToken(ctx));
        
        scope = function;
        super.visitFunctionDefinition(ctx);
        scope = function.getParent();
        
        return function;
    }
}
