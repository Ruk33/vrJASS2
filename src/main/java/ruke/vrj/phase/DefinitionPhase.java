package ruke.vrj.phase;

import org.antlr.v4.runtime.Token;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.symbol.*;

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
        
        Symbol type = scope.resolve(name);
    
        if (type == null) {
            type = new Symbol(name);
            type.addModifier(Modifier.TYPE);
            
            scope.define(type);
        }
        
        return type;
    }
    
    @Override
    public Symbol visitParam(vrjParser.ParamContext ctx) {
        String name = ctx.name().getText();
    
        checkAlreadyDefined(name, ctx.getStart(), "Variable");
        
        Symbol param = scope.resolve(name);
        
        if (param == null) {
            param = new Symbol(name, symbols.getToken(ctx));
    
            param.addModifier(Modifier.LOCAL);
            param.addModifier(Modifier.VARIABLE);
    
            if (scope instanceof FunctionSymbol) {
                ((FunctionSymbol) scope).defineParam(param);
                symbols.put(param);
            }
        }
        
        return param;
    }
    
    @Override
    public Symbol visitFunctionSignature(vrjParser.FunctionSignatureContext ctx) {
        String name = ctx.name().getText();
    
        checkAlreadyDefined(name, ctx.getStart(), "Function");
        
        Symbol function = scope.resolve(name);
    
        if (function instanceof FunctionSymbol == false) {
            function = new FunctionSymbol(name, symbols.getToken(ctx));
            
            function.addModifier(Modifier.FUNCTION);
    
            scope.define(function);
            symbols.put(function);
        }
    
        scope = function;
        visit(ctx.paramList());
        visit(ctx.type());
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx) {
        Symbol function = visit(ctx.functionSignature());
        
        if (ctx.visibility() != null && "private".equals(ctx.visibility().getText())) {
            function.setVisibility(Visibility.PRIVATE);
        }
        
        scope = function;
        visit(ctx.statements());
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        String name = ctx.name().getText();
        
        checkAlreadyDefined(name, ctx.getStart(), "Variable");
        
        Symbol variable = scope.resolve(name);
        
        if (variable == null) {
            variable = new Symbol(name, symbols.getToken(ctx));
            
            variable.addModifier(Modifier.VARIABLE);
    
            scope.define(variable);
            symbols.put(variable);
        }
        
        return variable;
    }
    
    @Override
    public Symbol visitLocalVariable(vrjParser.LocalVariableContext ctx) {
        Symbol variable = visit(ctx.variableStatement());
        
        variable.addModifier(Modifier.LOCAL);
        
        return variable;
    }
    
    @Override
    public Symbol visitLibraryDefinition(vrjParser.LibraryDefinitionContext ctx) {
        String name = ctx.name(0).getText();
        
        checkAlreadyDefined(name, ctx.name(0).getStart(), "Library");
        
        Symbol library = scope.resolve(name);
        
        if (library == null) {
            library = new ScopeSymbol(name, symbols.getToken(ctx));
            
            library.addModifier(Modifier.LIBRARY);
            
            scope.define(library);
            symbols.put(library);
        }
        
        scope = library;
        super.visitLibraryDefinition(ctx);
        scope = library.getParent();
        
        return library;
    }
    
    @Override
    public Symbol visitStructDefinition(vrjParser.StructDefinitionContext ctx) {
        String name = ctx.name().getText();
    
        checkAlreadyDefined(name, ctx.name().getStart(), "Struct");
        
        Symbol struct = scope.resolve(name);
        
        if (struct == null) {
            struct = new ScopeSymbol(name, symbols.getToken(ctx));
            
            struct.addModifier(Modifier.TYPE);
            struct.addModifier(Modifier.STRUCT);
    
            scope.define(struct);
            symbols.put(struct);
        }
    
        scope = struct;
        super.visitStructDefinition(ctx);
        scope = struct.getParent();
        
        return struct;
    }
    
    @Override
    public Symbol visitPropertyStatement(vrjParser.PropertyStatementContext ctx) {
        Symbol property = visit(ctx.variableStatement());
        
        if (ctx.visibility() != null && "private".equals(ctx.visibility().getText())) {
            property.setVisibility(Visibility.PRIVATE);
        }
        
        return property;
    }
    
    @Override
    public Symbol visitMethodDefinition(vrjParser.MethodDefinitionContext ctx) {
        Symbol method = visit(ctx.functionSignature());
        
        if (ctx.visibility() != null && "private".equals(ctx.visibility().getText())) {
            method.setVisibility(Visibility.PRIVATE);
        }
        
        scope = method;
        visit(ctx.statements());
        scope = method.getParent();
        
        return method;
    }
}
