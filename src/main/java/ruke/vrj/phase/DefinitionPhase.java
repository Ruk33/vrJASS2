package ruke.vrj.phase;

import ruke.vrj.antlr.vrjParser;
import ruke.vrj.symbol.*;

/**
 * Created by Ruke on 22/09/2016.
 */
public class DefinitionPhase extends BasePhase {
    
    public DefinitionPhase(Symbol scope) {
        super(scope);
    }
    
    @Override
    public Symbol visitNativeDefinition(vrjParser.NativeDefinitionContext ctx) {
        return visit(ctx.functionSignature());
    }
    
    @Override
    public Symbol visitTypeDefinition(vrjParser.TypeDefinitionContext ctx) {
        String name = ctx.typeName.getText();
        
        Symbol type = type = new Symbol(name);
        type.setSymbolType(SymbolType.TYPE);
        
        try {
            scope.define(type);
        } catch (Exception e) {
            addError(ctx.typeName.getStart(), String.format("Type %s is already defined", name));
        }
        
        return type;
    }
    
    @Override
    public Symbol visitParam(vrjParser.ParamContext ctx) {
        String name = ctx.name().getText();
        
        Symbol param = new Symbol(name, symbols.getToken(ctx));
        
        param.setVisibility(Visibility.PRIVATE);
        param.setSymbolType(SymbolType.VARIABLE);
        param.addModifier(Modifier.LOCAL);
    
        try {
            ((ScopeSymbol) scope).defineParam(param);
        } catch (Exception e) {
            addError(ctx.getStart(), String.format("Param %s is already defined", name));
        }
        
        symbols.put(param);
        
        return param;
    }
    
    @Override
    public Symbol visitFunctionSignature(vrjParser.FunctionSignatureContext ctx) {
        String name = ctx.name().getText();
        
        Symbol function = new ScopeSymbol(name, symbols.getToken(ctx));
        function.setSymbolType(SymbolType.FUNCTION);
        
        symbols.put(function);
    
        Symbol prevScope = scope;
    
        scope = function;
        visit(ctx.paramList());
        visit(ctx.type());
        scope = prevScope;
        
        return function;
    }
    
    @Override
    public Symbol visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx) {
        Symbol function = visit(ctx.functionSignature());
        
        if (ctx.visibility() != null && "private".equals(ctx.visibility().getText())) {
            function.setVisibility(Visibility.PRIVATE);
        }

        try {
            scope.define(function);
        } catch (Exception e) {
            addError(
                ctx.getStart(),
                String.format("Function %s is already defined", function.getName())
            );
        }
        
        scope = function;
        visit(ctx.statements());
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        String name = ctx.name().getText();
        
        Symbol variable = new Symbol(name, symbols.getToken(ctx));
        variable.setSymbolType(SymbolType.VARIABLE);
        
        if (ctx.array != null) {
            variable.addModifier(Modifier.ARRAY);
        }
    
        try {
            scope.define(variable);
        } catch (Exception e) {
            addError(ctx.name().getStart(), String.format("Variable %s is already defined", name));
        }
        
        symbols.put(variable);
        
        return variable;
    }
    
    @Override
    public Symbol visitGlobalVariable(vrjParser.GlobalVariableContext ctx) {
        Symbol variable = visit(ctx.variableStatement());
    
        if (ctx.visibility() != null && "private".equals(ctx.visibility().getText())) {
            variable.setVisibility(Visibility.PRIVATE);
        }
        
        if (ctx.constant != null) {
            variable.addModifier(Modifier.CONSTANT);
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
        
        Symbol library = new ScopeSymbol(name, symbols.getToken(ctx));
        library.setSymbolType(SymbolType.LIBRARY);
    
        try {
            scope.define(library);
        } catch (Exception e) {
            addError(ctx.name(0).getStart(), String.format("Library %s is already defined", name));
        }
        
        symbols.put(library);
        
        Symbol prevScope = scope;
        
        scope = library;
        visit(ctx.libraryBody());
        scope = prevScope;
        
        return library;
    }
    
    @Override
    public Symbol visitStructDefinition(vrjParser.StructDefinitionContext ctx) {
        String name = ctx.name().getText();
        
        Symbol struct = new StructSymbol(name, symbols.getToken(ctx));
        struct.setSymbolType(SymbolType.STRUCT);
    
        try {
            scope.define(struct);
        } catch (Exception e) {
            addError(ctx.name().getStart(), String.format("Struct %s is already defined", name));
        }
        
        symbols.put(struct);
    
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
        
        if (ctx.sstatic != null) {
            property.addModifier(Modifier.STATIC);
        }
        
        return property;
    }
    
    @Override
    public Symbol visitMethodDefinition(vrjParser.MethodDefinitionContext ctx) {
        Symbol method = visit(ctx.functionSignature());
        
        if (ctx.visibility() != null && "private".equals(ctx.visibility().getText())) {
            method.setVisibility(Visibility.PRIVATE);
        }
        
        if (ctx.sstatic != null) {
            method.addModifier(Modifier.STATIC);
        }
        
        if (ctx.operator != null) {
            method.setSymbolType(SymbolType.OPERATOR_OVERLOADING);
        }

        try {
            scope.define(method);
        } catch (Exception e) {
            addError(
                ctx.getStart(),
                String.format("Method %s is already defined", method.getName())
            );
        }
        
        Symbol prevScope = scope;
        
        scope = method;
        visit(ctx.statements());
        scope = prevScope;
        
        return method;
    }
}
