package ruke.vrj.phase;

import org.antlr.v4.runtime.Token;
import ruke.vrj.antlr.vrjBaseVisitor;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.exception.CompileException;
import ruke.vrj.lib.TokenSymbolMap;
import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public abstract class BasePhase extends vrjBaseVisitor<Symbol> {
    
    protected Symbol scope;
    protected Symbol nothing;
    protected TokenSymbolMap symbols;
    protected ArrayList<CompileException> errors;
    
    public BasePhase(Symbol scope) {
        this.scope = scope;
        
        nothing = scope.resolve("nothing");
        errors = new ArrayList<>();
        
        setTokenSymbolMap(new TokenSymbolMap());
    }
    
    public void setTokenSymbolMap(TokenSymbolMap symbols) {
        this.symbols = symbols;
    }
    
    public ArrayList<CompileException> getErrors() {
        return errors;
    }
    
    protected void addError(Token token, String message) {
        errors.add(new CompileException(token, message));
    }
    
    @Override
    public Symbol visitName(vrjParser.NameContext ctx) {
        Symbol resolved = scope.resolve(ctx.ID().getText());
        
        if (resolved == null) {
            resolved = nothing;
        }
        
        return resolved;
    }
    
    @Override
    public Symbol visitType(vrjParser.TypeContext ctx) {
        if ("nothing".equals(ctx.getText())) return nothing;
        return visit(ctx.getChild(0));
    }
    
    @Override
    public Symbol visitNegative(vrjParser.NegativeContext ctx) {
        return scope.resolve("real");
    }
    
    @Override
    public Symbol visitNot(vrjParser.NotContext ctx) {
        return scope.resolve("boolean");
    }
    
    @Override
    public Symbol visitMod(vrjParser.ModContext ctx) {
        return scope.resolve("real");
    }
    
    @Override
    public Symbol visitDiv(vrjParser.DivContext ctx) {
        return scope.resolve("real");
    }
    
    @Override
    public Symbol visitMult(vrjParser.MultContext ctx) {
        return scope.resolve("real");
    }
    
    @Override
    public Symbol visitSum(vrjParser.SumContext ctx) {
        return scope.resolve("real");
    }
    
    @Override
    public Symbol visitSub(vrjParser.SubContext ctx) {
        return scope.resolve("real");
    }
    
    @Override
    public Symbol visitComparison(vrjParser.ComparisonContext ctx) {
        return scope.resolve("boolean");
    }
    
    @Override
    public Symbol visitLogical(vrjParser.LogicalContext ctx) {
        return scope.resolve("boolean");
    }
    
    @Override
    public Symbol visitCode(vrjParser.CodeContext ctx) {
        return scope.resolve("code");
    }
    
    @Override
    public Symbol visitBoolean(vrjParser.BooleanContext ctx) {
        return scope.resolve("boolean");
    }
    
    @Override
    public Symbol visitNull(vrjParser.NullContext ctx) {
        return scope.resolve("null");
    }
    
    @Override
    public Symbol visitString(vrjParser.StringContext ctx) {
        return scope.resolve("string");
    }
    
    @Override
    public Symbol visitReal(vrjParser.RealContext ctx) {
        return scope.resolve("real");
    }
    
    @Override
    public Symbol visitInteger(vrjParser.IntegerContext ctx) {
        return scope.resolve("integer");
    }
    
}