package ruke.vrj.lib;

import ruke.vrj.antlr.vrjParser;
import ruke.vrj.symbol.Symbol;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;

/**
 * Created by Ruke on 24/09/2016.
 */
public class TokenSymbolMap {
    
    private HashMap<Token, Symbol> data = new HashMap<>();
    
    public TokenSymbolMap put(Token token, Symbol symbol) {
        data.put(token, symbol);
        return this;
    }
    
    public TokenSymbolMap put(Symbol symbol) {
        return put(symbol.getToken(), symbol);
    }
    
    public Symbol get(Token token) {
        return data.get(token);
    }
    
    public Token getToken(vrjParser.VariableStatementContext ctx) {
        return ctx.name().getStart();
    }
    
    public Token getToken(vrjParser.FunctionSignatureContext ctx) {
        return ctx.name().getStart();
    }
    
    public Token getToken(vrjParser.FunctionDefinitionContext ctx) {
        return getToken(ctx.functionSignature());
    }
    
    public Token getToken(vrjParser.ParamContext ctx) {
        return ctx.name().getStart();
    }
    
    public Token getToken(vrjParser.VariableExpressionContext ctx) {
        return ctx.name().getStart();
    }
    
    public Token getToken(vrjParser.FunctionExpressionContext ctx) {
        return ctx.name().getStart();
    }
    
    public Token getToken(vrjParser.CodeContext ctx) {
        return ctx.name().getStart();
    }
    
}
