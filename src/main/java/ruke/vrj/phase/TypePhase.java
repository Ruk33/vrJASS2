package ruke.vrj.phase;

import ruke.vrj.antlr.vrjParser;
import ruke.vrj.symbol.Symbol;

/**
 * Created by Ruke on 23/09/2016.
 */
public class TypePhase extends BasePhase {
    
    public TypePhase(Symbol scope) {
        super(scope);
    }
    
    @Override
    public Symbol visitFunctionSignature(vrjParser.FunctionSignatureContext ctx) {
        Symbol function = visit(ctx.name());
        
        function.setType(visit(ctx.type()));
    
        scope = function;
        super.visitFunctionSignature(ctx);
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx) {
        Symbol function = visit(ctx.functionSignature());
    
        symbols.put(symbols.getToken(ctx), function);
        
        scope = function;
        visit(ctx.statements());
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        Symbol variable = visit(ctx.name());
        
        variable.setType(visit(ctx.type()));
        
        super.visitVariableStatement(ctx);
        
        return variable;
    }
    
    @Override
    public Symbol visitParam(vrjParser.ParamContext ctx) {
        Symbol variable = visit(ctx.name());
    
        variable.setType(visit(ctx.type()));
    
        return variable;
    }
    
    @Override
    public Symbol visitVariableExpression(vrjParser.VariableExpressionContext ctx) {
        Symbol variable = visit(ctx.name());
        
        symbols.put(symbols.getToken(ctx), variable);
        
        super.visitVariableExpression(ctx);
        
        return variable;
    }
    
    @Override
    public Symbol visitFunctionExpression(vrjParser.FunctionExpressionContext ctx) {
        Symbol function = visit(ctx.name());
        
        symbols.put(symbols.getToken(ctx), function);
        
        super.visitFunctionExpression(ctx);
        
        return function;
    }
    
    @Override
    public Symbol visitCode(vrjParser.CodeContext ctx) {
        Symbol function = visit(ctx.name());
        
        symbols.put(symbols.getToken(ctx), function);
        
        return function;
    }
    
    @Override
    public Symbol visitLibraryDefinition(vrjParser.LibraryDefinitionContext ctx) {
        Symbol library = visit(ctx.name(0));
    
        symbols.put(symbols.getToken(ctx), library);
    
        scope = library;
        super.visitLibraryDefinition(ctx);
        scope = library.getParent();
        
        return library;
    }
    
    @Override
    public Symbol visitStructDefinition(vrjParser.StructDefinitionContext ctx) {
        Symbol struct = visit(ctx.name());
        
        symbols.put(symbols.getToken(ctx), struct);
        
        scope = struct;
        super.visitStructDefinition(ctx);
        scope = struct.getParent();
        
        return struct;
    }
    
    @Override
    public Symbol visitPropertyStatement(vrjParser.PropertyStatementContext ctx) {
        Symbol property = visit(ctx.variableStatement());
        
        symbols.put(symbols.getToken(ctx), property);
        super.visitPropertyStatement(ctx);
        
        return property;
    }
    
    @Override
    public Symbol visitMethodDefinition(vrjParser.MethodDefinitionContext ctx) {
        Symbol method = visit(ctx.functionSignature());
        
        symbols.put(symbols.getToken(ctx), method);
        
        scope = method;
        super.visitMethodDefinition(ctx);
        scope = method.getParent();
        
        return method;
    }
}
