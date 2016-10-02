package ruke.vrj.phase;

import ruke.vrj.antlr.vrjBaseVisitor;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.lib.TokenSymbolMap;
import ruke.vrj.translator.*;

/**
 * Created by Ruke on 24/09/2016.
 */
public class TranslatorPhase extends vrjBaseVisitor<Expression> {
    
    private TokenSymbolMap symbols;
    private GlobalsStatement globals;
    
    public TranslatorPhase(TokenSymbolMap symbols) {
        this.symbols = symbols;
        globals = new GlobalsStatement();
    }
    
    @Override
    public Expression visitInit(vrjParser.InitContext ctx) {
        Expression result = new StatementList();
        
        result.append(globals);
        
        for (int i = 0, max = ctx.getChildCount(); i < max; i++) {
            result.append(visit(ctx.getChild(i)));
        }
        
        return result;
    }
    
    @Override
    public Expression visitName(vrjParser.NameContext ctx) {
        return new RawExpression(ctx.getText());
    }
    
    @Override
    public Expression visitExpressionList(vrjParser.ExpressionListContext ctx) {
        Expression result = new ExpressionList();
        
        for (vrjParser.ExpressionContext expr : ctx.expression()) {
            result.append(visit(expr));
        }
        
        return result;
    }
    
    @Override
    public Expression visitFunctionExpression(vrjParser.FunctionExpressionContext ctx) {
        Expression function = new FunctionExpression().setSymbol(symbols.get(symbols.getToken(ctx)));
        
        if (ctx.arguments().expressionList() != null) {
            function.append(visit(ctx.arguments().expressionList()));
        }
        
        return function;
    }
    
    @Override
    public Expression visitVariableExpression(vrjParser.VariableExpressionContext ctx) {
        Expression result = new VariableExpression().setSymbol(symbols.get(symbols.getToken(ctx)));
        
        if (ctx.expression() != null) {
            result.append(new BracketExpression().append(visit(ctx.expression())));
        }
        
        return result;
    }
    
    @Override
    public Expression visitParenthesis(vrjParser.ParenthesisContext ctx) {
        return new ParenthesisExpression().append(visit(ctx.expression()));
    }
    
    @Override
    public Expression visitNegative(vrjParser.NegativeContext ctx) {
        return new NegativeExpression().append(visit(ctx.expression()));
    }
    
    @Override
    public Expression visitNot(vrjParser.NotContext ctx) {
        return new NotExpression().append(visit(ctx.expression()));
    }
    
    @Override
    public Expression visitMod(vrjParser.ModContext ctx) {
        Expression a = visit(ctx.expression(0));
        Expression b = visit(ctx.expression(1));
    
        return new ModuloExpression().append(a).append(b);
    }
    
    @Override
    public Expression visitDiv(vrjParser.DivContext ctx) {
        Expression a = visit(ctx.expression(0));
        Expression b = visit(ctx.expression(1));
    
        return new DivisionExpression().append(a).append(b);
    }
    
    @Override
    public Expression visitMult(vrjParser.MultContext ctx) {
        Expression a = visit(ctx.expression(0));
        Expression b = visit(ctx.expression(1));
    
        return new MultiplicationExpression().append(a).append(b);
    }
    
    @Override
    public Expression visitSum(vrjParser.SumContext ctx) {
        Expression a = visit(ctx.expression(0));
        Expression b = visit(ctx.expression(1));
    
        return new AditionExpression().append(a).append(b);
    }
    
    @Override
    public Expression visitSub(vrjParser.SubContext ctx) {
        Expression a = visit(ctx.expression(0));
        Expression b = visit(ctx.expression(1));
        
        return new SubstractionExpression().append(a).append(b);
    }
    
    @Override
    public Expression visitComparison(vrjParser.ComparisonContext ctx) {
        Expression a = visit(ctx.expression(0));
        Expression b = visit(ctx.expression(1));
        
        Expression result = new EqualExpression();
        
        switch (ctx.operator.getText()) {
            //case "==":
            //    result = new EqualExpression();
            //    break;
            case "!=":
                result = new NotEqualExpression();
                break;
            case "<=":
                result = new LessEqualExpression();
                break;
            case "<":
                result = new LessThanExpression();
                break;
            case ">=":
                result = new GreaterEqualExpression();
                break;
            case ">":
                result = new GreaterThanExpression();
                break;
        }
        
        return result.append(a).append(b);
    }
    
    @Override
    public Expression visitLogical(vrjParser.LogicalContext ctx) {
        Expression a = visit(ctx.expression(0));
        Expression b = visit(ctx.expression(1));
        
        Expression result;
        
        if ("or".equals(ctx.operator.getText())) {
            result = new OrExpression();
        } else {
            result = new AndExpression();
        }
        
        return result.append(a).append(b);
    }
    
    @Override
    public Expression visitCode(vrjParser.CodeContext ctx) {
        return new CodeExpression().setSymbol(symbols.get(symbols.getToken(ctx)));
    }
    
    @Override
    public Expression visitBoolean(vrjParser.BooleanContext ctx) {
        return new RawExpression(ctx.getText());
    }
    
    @Override
    public Expression visitNull(vrjParser.NullContext ctx) {
        return new RawExpression("null");
    }
    
    @Override
    public Expression visitString(vrjParser.StringContext ctx) {
        return new RawExpression(ctx.getText());
    }
    
    @Override
    public Expression visitReal(vrjParser.RealContext ctx) {
        return new RawExpression(ctx.getText());
    }
    
    @Override
    public Expression visitInteger(vrjParser.IntegerContext ctx) {
        return new RawExpression(ctx.getText());
    }
    
    @Override
    public Expression visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        Expression variable = new VariableStatement().setSymbol(symbols.get(symbols.getToken(ctx)));
        
        if (ctx.expression() != null) {
            variable.append(visit(ctx.expression()));
        }
        
        return variable;
    }
    
    @Override
    public Expression visitGlobalDefinition(vrjParser.GlobalDefinitionContext ctx) {
        for (vrjParser.VariableStatementContext variable : ctx.variableStatement()) {
            globals.append(visit(variable));
        }
        
        return null;
    }
    
    @Override
    public Expression visitLoopStatement(vrjParser.LoopStatementContext ctx) {
        Expression loop = new LoopStatement();
        
        loop.append(visit(ctx.statements()));
        
        return loop;
    }
    
    @Override
    public Expression visitIfStatement(vrjParser.IfStatementContext ctx) {
        Expression _if = new IfStatement();
        
        _if.append(visit(ctx.expression()));
        _if.append(visit(ctx.statements()));
        
        if (ctx.elseIfStatement() != null) {
            for (vrjParser.ElseIfStatementContext stat : ctx.elseIfStatement()) {
                _if.append(visit(stat));
            }
        }
        
        if (ctx.elseStatement() != null) {
            _if.append(visit(ctx.elseStatement()));
        }
        
        return _if;
    }
    
    @Override
    public Expression visitElseIfStatement(vrjParser.ElseIfStatementContext ctx) {
        Expression elif = new ElseIfStatement();
        
        elif.append(visit(ctx.expression()));
        elif.append(visit(ctx.statements()));
        
        return elif;
    }
    
    @Override
    public Expression visitElseStatement(vrjParser.ElseStatementContext ctx) {
        Expression _else = new ElseStatement();
        
        _else.append(visit(ctx.statements()));
        
        return _else;
    }
    
    @Override
    public Expression visitLocalVariable(vrjParser.LocalVariableContext ctx) {
        return visit(ctx.variableStatement());
    }
    
    @Override
    public Expression visitSetVariable(vrjParser.SetVariableContext ctx) {
        Expression result = new SetVariableStatement();
        
        result.append(visit(ctx.variableExpression()));
        result.append(visit(ctx.expression()));
        
        return result;
    }
    
    @Override
    public Expression visitExitwhen(vrjParser.ExitwhenContext ctx) {
        return new ExitWhenStatement().append(visit(ctx.expression()));
    }
    
    @Override
    public Expression visitFunctionCall(vrjParser.FunctionCallContext ctx) {
        return new FunctionStatement().append(visit(ctx.functionExpression()));
    }
    
    @Override
    public Expression visitReturn(vrjParser.ReturnContext ctx) {
        Expression result = new ReturnStatement();
        
        if (ctx.expression() != null) {
            result.append(visit(ctx.expression()));
        }
        
        return result;
    }
    
    @Override
    public Expression visitStatements(vrjParser.StatementsContext ctx) {
        Expression statements = new StatementList();
        
        if (ctx.statement() != null) {
            for (vrjParser.StatementContext stat : ctx.statement()) {
                statements.append(visit(stat));
            }
        }
        
        return statements;
    }
    
    @Override
    public Expression visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx) {
        Expression function = new FunctionDefinition().setSymbol(symbols.get(symbols.getToken(ctx)));
        
        function.append(visit(ctx.statements()));
        
        return function;
    }
    
}
