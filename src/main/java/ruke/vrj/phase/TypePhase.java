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
        
        scope = function;
        visit(ctx.statements());
        scope = function.getParent();
        
        return function;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        Symbol variable = visit(ctx.name());
        
        variable.setType(visit(ctx.type()));
        
        return variable;
    }
    
    @Override
    public Symbol visitParam(vrjParser.ParamContext ctx) {
        Symbol variable = visit(ctx.name());
    
        variable.setType(visit(ctx.type()));
    
        return variable;
    }
    
}
