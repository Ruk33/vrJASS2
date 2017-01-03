package ruke.vrj.phase;

import org.antlr.v4.runtime.ParserRuleContext;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.lib.LevenshteinDistance;
import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.Symbol;
import ruke.vrj.symbol.SymbolType;
import ruke.vrj.validator.TypeCompatible;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Ruke on 25/09/2016.
 */
public class SuggestionPhase extends BasePhase {
    
    private LevenshteinDistance comparator;
    private ArrayList<Suggestion> suggestions;
    private TypeCompatible typeCompatible;
    
    private Symbol type;
    private Modifier modifier;
    private SymbolType symbolType;
    
    private int line;
    private int _char;
    
    private class Suggestion implements Comparable<Suggestion> {
        private Symbol symbol;
        private int points;
        
        public Suggestion(Symbol symbol, int points) {
            this.symbol = symbol;
            this.points = points;
        }
    
        public Symbol getSymbol() {
            return symbol;
        }
    
        @Override
        public int compareTo(Suggestion o) {
            return points - o.points;
        }
    }
    
    public SuggestionPhase(Symbol scope, int line, int _char) {
        super(scope);
        
        comparator = new LevenshteinDistance();
        suggestions = new ArrayList<>();
        typeCompatible = new TypeCompatible();
        
        this.line = line;
        this._char = _char;
    }
    
    public ArrayList<Symbol> getSuggestions() {
        Collections.sort(suggestions);
        
        ArrayList<Symbol> results = new ArrayList<>();
        
        for (Suggestion s : suggestions) {
            results.add(s.getSymbol());
        }
        
        return results;
    }
    
    private boolean inCursorLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine() == line;
    }
    
    private boolean inCursorRange(ParserRuleContext ctx) {
        return
            (
                // If the expression is not present, this condition will be true
                // Example: call |
                // Where | is the cursor. Notice the name of the function isn't present
                ctx.getStart().getCharPositionInLine() == _char &&
                ctx.getStop().getCharPositionInLine() == 0
            )
                ||
            (
                ctx.getStart().getCharPositionInLine() < _char &&
                ctx.getStop().getCharPositionInLine() + 1 >= _char
            )
                ||
            (
                // call Ch|
                // In this case, Ch is a function expression, but since the args
                // are missing, the start and end are equal
                ctx.getStart().getCharPositionInLine() == ctx.getStop().getCharPositionInLine() &&
                ctx.getStart().getCharPositionInLine() + ctx.getText().length() == _char
            );
    }
    
    private void fillSuggestions(String search) {
        if (!suggestions.isEmpty()) {
            return;
        }
        
        Symbol parent = scope;
        String firstLetter = null;
        
        if (search != null) {
            search = search.trim();
            if (search.length() == 0) {
                search = null;
            } else {
                search = search.toLowerCase();
                firstLetter = search.substring(0, 1);
            }
        }
        
        while (parent != null) {
            Collection<Symbol> childs;
            
            if (firstLetter != null) {
                childs = parent.getChildsByFirstLetter(firstLetter);
            } else {
                childs = parent.getChilds();
            }
            
            for (Symbol child : childs) {
                if (suggestions.size() >= 20) {
                    parent = null;
                    break;
                }
                
                if (modifier != null && !child.hasModifier(modifier)) {
                    //continue;
                }
                
                if (symbolType != null && child.getSymbolType() != symbolType) {
                    continue;
                }
                
                if (type != null) {
                    if (child.getSymbolType() != SymbolType.TYPE) continue;
                    if (type == child) continue;
                    if (!typeCompatible.compatible(type, child)) continue;
                }
                
                int points = 0;
                
                if (search != null) {
                    if (!child.getName().toLowerCase().contains(search)) {
                        continue;
                    }
                    
                    points = comparator.computeLevenshteinDistance(child.getName(), search);
                    
                    if (points > 15) {
                        continue;
                    }
                }
                
                suggestions.add(new Suggestion(child, points));
            }
            
            if (parent != null) {
                parent = parent.getParent();
            }
        }
    }
    
    @Override
    public Symbol visitType(vrjParser.TypeContext ctx) {
        if (!inCursorLine(ctx)) {
            return null;
        }
    
        if (inCursorRange(ctx)) {
            type = null;
            symbolType = SymbolType.TYPE;
    
            fillSuggestions(null);
        }
    
        return null;
    }
    
    @Override
    public Symbol visitFunctionExpression(vrjParser.FunctionExpressionContext ctx) {
        if (!inCursorLine(ctx)) {
            return null;
        }
        
        if (inCursorRange(ctx.name())) {
            symbolType = SymbolType.FUNCTION;
            fillSuggestions(ctx.name().getText());
            return null;
        }
        
        Symbol function = symbols.get(symbols.getToken(ctx));
        ArrayList<Symbol> params;
        
        if (function instanceof ScopeSymbol) {
            params = ((ScopeSymbol) function).getParams();
            
            if (params.size() == 0) {
                return null;
            }
    
            if (ctx.arguments().expressionList() == null) {
                type = params.get(0);
                fillSuggestions(null);
                return null;
            }
            
            int paramIndex = 0;
            vrjParser.ExpressionContext last = null;
            
            for (vrjParser.ExpressionContext expr : ctx.arguments().expressionList().expression()) {
                type = params.get(paramIndex);
                
                if (inCursorRange(expr)) {
                    visit(expr);
                }
                
                paramIndex++;
                last = expr;
                
                if (paramIndex >= params.size()) {
                    break;
                }
            }
            
            if (last.getChildCount() == 0) {
                fillSuggestions(null);
            } else {
                visit(last);
            }
        }
        
        return null;
    }
    
    @Override
    public Symbol visitVariableExpression(vrjParser.VariableExpressionContext ctx) {
        if (!inCursorLine(ctx)) {
            return null;
        }
    
        if (inCursorRange(ctx.name())) {
            fillSuggestions(ctx.name().getText());
        }
        
        return null;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        if (!inCursorLine(ctx)) {
            return null;
        }
        
        if (ctx.expression() != null) {
            type = symbols.get(symbols.getToken(ctx));
            
            if (ctx.expression().getChildCount() == 0) {
                fillSuggestions(null);
            } else {
                visit(ctx.expression());
            }
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
