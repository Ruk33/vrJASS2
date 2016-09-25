package ruke.vrj.phase;

import ruke.vrj.antlr.vrjParser;
import ruke.vrj.symbol.FunctionSymbol;
import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.Symbol;
import org.antlr.v4.runtime.Token;

/**
 * Created by Ruke on 22/09/2016.
 */
public class DefinitionPhase extends BasePhase {
    
    public DefinitionPhase(Symbol scope) {
        super(scope);
    }
    
    private void checkAlreadyDefined(String name, Token token, String type) {
        if (scope.resolve(name) != null) {
            addError(token, type + " " + name + " is already defined");
        }
    }
    
    @Override
    public Symbol visitTypeDefinition(vrjParser.TypeDefinitionContext ctx) {
        String name = ctx.typeName.getText();
        
        checkAlreadyDefined(name, ctx.getStart(), "Type");
        
        Symbol type = new Symbol(name);
    
        type.addModifier(Modifier.TYPE);
        scope.define(type);
        
        return type;
    }
    
    @Override
    public Symbol visitParam(vrjParser.ParamContext ctx) {
        String name = ctx.name().getText();
    
        checkAlreadyDefined(name, ctx.getStart(), "Variable");
        
        Symbol param = new Symbol(name, symbols.getToken(ctx));
    
        param.addModifier(Modifier.LOCAL);
        param.addModifier(Modifier.VARIABLE);
        
        if (scope instanceof FunctionSymbol) {
            ((FunctionSymbol) scope).defineParam(param);
            symbols.put(param);
        }
        
        return param;
    }
    
    @Override
    public Symbol visitFunctionSignature(vrjParser.FunctionSignatureContext ctx) {
        String name = ctx.name().getText();
    
        checkAlreadyDefined(name, ctx.getStart(), "Function");
        
        FunctionSymbol function = new FunctionSymbol(name, symbols.getToken(ctx));
    
        function.addModifier(Modifier.FUNCTION);
        
        scope.define(function);
        symbols.put(function);
    
        scope = function;
        super.visitFunctionSignature(ctx);
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx) {
        Symbol function = visit(ctx.functionSignature());
        
        scope = function;
        visit(ctx.statements());
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        String name = ctx.name().getText();
        
        checkAlreadyDefined(name, ctx.getStart(), "Variable");
        
        Symbol variable = new Symbol(name, symbols.getToken(ctx));
    
        variable.addModifier(Modifier.VARIABLE);
        
        scope.define(variable);
        symbols.put(variable);
        
        return variable;
    }
    
    @Override
    public Symbol visitLocalVariable(vrjParser.LocalVariableContext ctx) {
        Symbol variable = visit(ctx.variableStatement());
        
        variable.addModifier(Modifier.LOCAL);
        
        return variable;
    }
}
