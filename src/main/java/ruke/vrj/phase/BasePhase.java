package ruke.vrj.phase;

import org.antlr.v4.runtime.tree.TerminalNode;
import ruke.vrj.antlr.vrjBaseVisitor;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.exception.CompileException;
import ruke.vrj.lib.TokenSymbolMap;
import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.Symbol;
import org.antlr.v4.runtime.Token;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Ruke on 23/09/2016.
 */
public abstract class BasePhase extends vrjBaseVisitor<Symbol> {
    
    protected Symbol scope;
    protected TokenSymbolMap symbols;
    protected HashMap<String, CompileException> errors;
    protected HashMap<String, Symbol> natives;
    
    public BasePhase(Symbol scope) {
        this.scope = scope;
        
        setTokenSymbolMap(new TokenSymbolMap());
        
        errors = new HashMap<>();
        natives = new HashMap<>();
        
        scope.define(new Symbol("integer").addModifier(Modifier.TYPE));
        scope.define(new Symbol("real").addModifier(Modifier.TYPE));
        scope.define(new Symbol("boolean").addModifier(Modifier.TYPE));
        scope.define(new Symbol("string").addModifier(Modifier.TYPE));
        scope.define(new Symbol("code").addModifier(Modifier.TYPE));
        scope.define(new Symbol("nothing").addModifier(Modifier.TYPE));
        scope.define(new Symbol("null").addModifier(Modifier.TYPE));
        scope.define(new Symbol("handle").addModifier(Modifier.TYPE));
    
        natives.put("integer", this.scope.resolve("integer"));
        natives.put("real", this.scope.resolve("real"));
        natives.put("boolean", this.scope.resolve("boolean"));
        natives.put("string", this.scope.resolve("string"));
        natives.put("code", this.scope.resolve("code"));
        natives.put("nothing", this.scope.resolve("nothing"));
        natives.put("null", this.scope.resolve("null"));
        natives.put("handle", this.scope.resolve("handle"));
    }
    
    public void setTokenSymbolMap(TokenSymbolMap symbols) {
        this.symbols = symbols;
    }
    
    public Collection<CompileException> getErrors() {
        return errors.values();
    }
    
    protected void addError(Token token, String message) {
        CompileException exception = new CompileException(token, message);
        errors.put(exception.getMessage(), exception);
    }
    
    @Override
    public Symbol visitName(vrjParser.NameContext ctx) {
        Symbol symbol = scope;
        
        for (TerminalNode id : ctx.ID()) {
            symbol = symbol.resolve(scope, id.getText());
        }
        
        if (symbol == scope) {
            symbol = null;
        }
        
        if (symbol == null) {
            symbol = natives.get("nothing");
        }
        
        return symbol;
    }
    
    @Override
    public Symbol visitType(vrjParser.TypeContext ctx) {
        return scope.resolve(ctx.getText());
    }
    
    @Override
    public Symbol visitNegative(vrjParser.NegativeContext ctx) {
        return natives.get("real");
    }
    
    @Override
    public Symbol visitNot(vrjParser.NotContext ctx) {
        return natives.get("boolean");
    }
    
    @Override
    public Symbol visitMod(vrjParser.ModContext ctx) {
        return natives.get("real");
    }
    
    @Override
    public Symbol visitDiv(vrjParser.DivContext ctx) {
        return natives.get("real");
    }
    
    @Override
    public Symbol visitMult(vrjParser.MultContext ctx) {
        return natives.get("real");
    }
    
    @Override
    public Symbol visitSum(vrjParser.SumContext ctx) {
        return natives.get("real");
    }
    
    @Override
    public Symbol visitSub(vrjParser.SubContext ctx) {
        return natives.get("real");
    }
    
    @Override
    public Symbol visitComparison(vrjParser.ComparisonContext ctx) {
        return natives.get("boolean");
    }
    
    @Override
    public Symbol visitLogical(vrjParser.LogicalContext ctx) {
        return natives.get("boolean");
    }
    
    @Override
    public Symbol visitCode(vrjParser.CodeContext ctx) {
        return natives.get("code");
    }
    
    @Override
    public Symbol visitBoolean(vrjParser.BooleanContext ctx) {
        return natives.get("boolean");
    }
    
    @Override
    public Symbol visitNull(vrjParser.NullContext ctx) {
        return natives.get("null");
    }
    
    @Override
    public Symbol visitString(vrjParser.StringContext ctx) {
        return natives.get("string");
    }
    
    @Override
    public Symbol visitReal(vrjParser.RealContext ctx) {
        return natives.get("real");
    }
    
    @Override
    public Symbol visitInteger(vrjParser.IntegerContext ctx) {
        return natives.get("integer");
    }
    
}