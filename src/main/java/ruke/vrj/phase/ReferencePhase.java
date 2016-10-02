package ruke.vrj.phase;

import org.antlr.v4.runtime.ParserRuleContext;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.symbol.FunctionSymbol;
import ruke.vrj.symbol.Symbol;
import ruke.vrj.validator.Validator;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruke on 23/09/2016.
 */
public class ReferencePhase extends BasePhase {
    
    private int line;
    private int range;
    
    private Validator validator;
    
    public ReferencePhase(Symbol scope, int line, int range) {
        super(scope);
        
        this.line = line;
        this.range = range;
        
        setValidator(new Validator());
    }
    
    public void setValidator(Validator validator) {
        this.validator = validator;
    }
    
    private boolean inRange(Token token) {
        if (line == -1) {
            return true;
        }
        return line + range >= token.getLine() && line - range <= token.getLine();
    }
    
    private boolean inRange(ParserRuleContext ctx) {
        return inRange(ctx.getStart());
    }
    
    private void checkForVariable(Symbol symbol, Token token) {
        if (!inRange(token)) {
            return;
        }
        
        if (!this.validator.isVariable(symbol)) {
            addError(token, token.getText() + " is not a variable");
        }
    }
    
    private void checkForFunction(Symbol symbol, Token token) {
        if (!inRange(token)) {
            return;
        }
        
        if (!this.validator.isFunction(symbol)) {
            addError(token, token.getText() + " is not a function");
        }
    }
    
    public void checkCompatibleType(Symbol a, Symbol b, Token token) {
        if (!inRange(token)) {
            return;
        }
        
        if (!this.validator.isTypeCompatible(a, b)) {
            if (a == null || b == null) {
                addError(token, "Expected type");
            } else {
                addError(
                    token,
                    "Incompatible type. " +
                        "Expected " + a.getType().getName() + " " +
                        "but " + b.getType().getName() + " given"
                );
            }
        }
    }
    
    private void checkForNumeric(Symbol symbol, Token token) {
        if (!inRange(token)) {
            return;
        }
        
        if (!this.validator.isNumber(symbol)) {
            addError(token, token.getText() + " is not a numeric expression");
        }
    }
    
    private void checkForBoolean(Symbol symbol, Token token) {
        if (!inRange(token)) {
            return;
        }
        
        if (!this.validator.isBoolean(symbol)) {
            addError(token, token.getText() + " is not a boolean expression");
        }
    }
    
    private void checkForValidType(Symbol symbol, Token token) {
        if (!inRange(token)) {
            return;
        }
        
        if (!this.validator.isValidType(symbol)) {
            addError(token, symbol.getName() + " is not a valid type");
        }
    }
    
    @Override
    public Symbol visitName(vrjParser.NameContext ctx) {
        Symbol symbol = scope.resolve(ctx.getText());
        
        if (symbol == null) {
            addError(ctx.getStart(), ctx.getText() + " is not defined");
            symbol = natives.get("nothing");
        }
        
        return symbol;
    }
    
    @Override
    public Symbol visitType(vrjParser.TypeContext ctx) {
        Symbol type = scope.resolve(ctx.getText());
        
        if (type == null) {
            addError(ctx.getStart(), ctx.getText() + " is not defined");
            type = natives.get("nothing");
        }
        
        checkForValidType(type, ctx.getStart());
        
        return type;
    }
    
    @Override
    public Symbol visitParenthesis(vrjParser.ParenthesisContext ctx) {
        return visit(ctx.expression());
    }
    
    @Override
    public Symbol visitNegative(vrjParser.NegativeContext ctx) {
        checkForNumeric(visit(ctx.expression()), ctx.expression().getStart());
        return natives.get("real");
    }
    
    @Override
    public Symbol visitNot(vrjParser.NotContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression().getStart());
        return natives.get("boolean");
    }
    
    @Override
    public Symbol visitMod(vrjParser.ModContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return natives.get("real");
    }
    
    @Override
    public Symbol visitDiv(vrjParser.DivContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return natives.get("real");
    }
    
    @Override
    public Symbol visitMult(vrjParser.MultContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return natives.get("real");
    }
    
    @Override
    public Symbol visitSum(vrjParser.SumContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return natives.get("real");
    }
    
    @Override
    public Symbol visitSub(vrjParser.SubContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return natives.get("real");
    }
    
    @Override
    public Symbol visitVariableExpression(vrjParser.VariableExpressionContext ctx) {
        Symbol variable = visit(ctx.name());
        
        if (!inRange(ctx)) {
            return variable.getType();
        }
    
        checkForVariable(variable, ctx.name().getStart());
        
        super.visitVariableExpression(ctx);
        
        return variable.getType();
    }
    
    @Override
    public Symbol visitFunctionExpression(vrjParser.FunctionExpressionContext ctx) {
        Symbol function = visit(ctx.name());
        
        if (!inRange(ctx)) {
            return function.getType();
        }
        
        checkForFunction(function, ctx.name().getStart());
        
        if (this.validator.isFunction(function)) {
            ArrayList<Symbol> params = ((FunctionSymbol) function).getParams();
            List<vrjParser.ExpressionContext> exprs = null;
            
            if (ctx.arguments().expressionList() != null) {
                exprs = ctx.arguments().expressionList().expression();
            } else {
                exprs = new ArrayList<>();
            }
            
            if (params.size() != exprs.size()) {
                addError(
                    ctx.getStart(),
                    "Incorrect argument count. Expected " + params.size() + " arguments"
                );
            }
            
            for (int i = 0, max = params.size(); i < max; i++) {
                Symbol expected = params.get(i);
                Symbol given = null;
                
                if (exprs.size() - 1 >= i) {
                    given = visit(exprs.get(i));
                }
                
                if (given == null) {
                    continue;
                }
                
                checkCompatibleType(expected, given, exprs.get(i).getStart());
            }
        }
        
        return function.getType();
    }
    
    @Override
    public Symbol visitComparison(vrjParser.ComparisonContext ctx) {
        checkForBoolean(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForBoolean(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return natives.get("boolean");
    }
    
    @Override
    public Symbol visitLogical(vrjParser.LogicalContext ctx) {
        checkForBoolean(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForBoolean(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return natives.get("boolean");
    }
    
    @Override
    public Symbol visitCode(vrjParser.CodeContext ctx) {
        Symbol function = visit(ctx.name());
        
        checkForFunction(function, ctx.name().getStart());
        
        return natives.get("code");
    }
    
    @Override
    public Symbol visitParam(vrjParser.ParamContext ctx) {
        visit(ctx.type());
        return visit(ctx.name());
    }
    
    @Override
    public Symbol visitFunctionSignature(vrjParser.FunctionSignatureContext ctx) {
        return visit(ctx.name());
    }
    
    @Override
    public Symbol visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx) {
        Symbol function = visit(ctx.functionSignature());
        
        scope = function;
        super.visitFunctionDefinition(ctx);
        scope = function.getParent();
    
        return function;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        Symbol variable = visit(ctx.name());
        
        if (ctx.expression() != null) {
            Symbol value = visit(ctx.expression());
            checkCompatibleType(variable, value, ctx.expression().getStart());
        }
        
        super.visitVariableStatement(ctx);
        
        return variable;
    }
    
    @Override
    public Symbol visitSetVariable(vrjParser.SetVariableContext ctx) {
        Symbol variable = visit(ctx.variableExpression());
        
        checkCompatibleType(variable, visit(ctx.expression()), ctx.expression().getStart());
        
        super.visitSetVariable(ctx);
        
        return variable;
    }
    
    @Override
    public Symbol visitExitwhen(vrjParser.ExitwhenContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression().getStart());
        return super.visitExitwhen(ctx);
    }
    
    @Override
    public Symbol visitIfStatement(vrjParser.IfStatementContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression().getStart());
        return super.visitIfStatement(ctx);
    }
    
    @Override
    public Symbol visitElseIfStatement(vrjParser.ElseIfStatementContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression().getStart());
        return super.visitElseIfStatement(ctx);
    }
    
    @Override
    public Symbol visitReturn(vrjParser.ReturnContext ctx) {
        if (ctx.expression() != null) {
            Symbol value = visit(ctx.expression());
            checkCompatibleType(scope, value, ctx.expression().getStart());
        } else if (scope.getType() != scope) {
            addError(ctx.getStart(), "Must return a value");
        }
        
        return super.visitReturn(ctx);
    }
}
