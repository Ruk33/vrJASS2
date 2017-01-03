package ruke.vrj.phase;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.resolution.NonStaticMemberResolution;
import ruke.vrj.resolution.Resolution;
import ruke.vrj.resolution.StaticMemberResolution;
import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.ScopeSymbol;
import ruke.vrj.symbol.Symbol;
import ruke.vrj.symbol.SymbolType;
import ruke.vrj.validator.Validator;

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
    
    private void checkForValidEqualityExpression(Symbol a, Symbol b, ParserRuleContext ctx) {
        if (!inRange(ctx)) {
            return;
        }
        
        if (!this.validator.isTypeCompatible(a, b)) {
            addError(
                ctx.getStart(),
                "Comparing two variables of different primitive types (expect real and integer) is not allowed"
            );
        }
    }
    
    private void checkForValidSizeExpression(Symbol a, Symbol b, ParserRuleContext ctx) {
        if (!inRange(ctx)) {
            return;
        }
        
        boolean aIsNumeric = this.validator.isNumber(a);
        boolean bIsNumeric = this.validator.isNumber(b);
        
        if (!aIsNumeric || !bIsNumeric) {
            addError(
                ctx.getStart(),
                "Comparing the order/size of 2 variables only works on reals and integers"
            );
        }
    }
    
    private boolean scopeHasReturn(vrjParser.StatementsContext stats) {
        for (vrjParser.StatementContext stat : stats.statement()) {
            if (stat.returnStatement() != null) {
                return true;
            } else if (stat.ifStatement() != null) {
                if (stat.ifStatement().elseStatement() != null) {
                    boolean ifReturns = scopeHasReturn(stat.ifStatement().statements());
                    boolean elseIfReturns = true;
                    boolean elseReturns = scopeHasReturn(stat.ifStatement().elseStatement().statements());
                
                    for (vrjParser.ElseIfStatementContext elseif : stat.ifStatement().elseIfStatement()) {
                        if (!scopeHasReturn(elseif.statements())) {
                            elseIfReturns = false;
                            break;
                        }
                    }
                
                    if (ifReturns && elseIfReturns && elseReturns) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private void checkMissingReturn(Symbol function, vrjParser.StatementsContext stats) {
        if (function.getType() == function || function.getType() == scope.resolve("nothing")) {
            return;
        }
        
        if (!scopeHasReturn(stats)) {
            addError(function.getToken(), "Missing return");
        }
    }
    
    private void checkLibraryRequirement(Symbol requirement, ParserRuleContext ctx) {
        if (requirement.getName().equals("nothing")) {
            return;
        }
        
        if (requirement.getSymbolType() != SymbolType.LIBRARY) {
            addError(
                ctx.getStart(),
                String.format("%s is not a library", ctx.getText())
            );
        }
    }
    
    private void checkForDefined(Symbol symbol, ParserRuleContext ctx) {
        if (!inRange(ctx.getStart())) {
            return;
        }
    
        if (symbol.getName().equals("nothing")) {
            addError(ctx.getStart(), ctx.getText() + " is not defined");
        }
    }
    
    private void checkForVariable(Symbol symbol, ParserRuleContext ctx) {
        if (!inRange(ctx.getStart())) {
            return;
        }
        
        if (symbol.getName().equals("nothing")) {
            return;
        }
        
        if (!this.validator.isVariable(symbol)) {
            addError(ctx.getStart(), ctx.getText() + " is not a variable");
        }
    }
    
    private void checkForFunction(Symbol symbol, ParserRuleContext ctx) {
        if (!inRange(ctx.getStart())) {
            return;
        }
    
        if (symbol.getName().equals("nothing")) {
            return;
        }
        
        if (!this.validator.isFunction(symbol)) {
            addError(ctx.getStart(), ctx.getText() + " is not a function");
        }
    }
    
    public void checkCompatibleType(Symbol a, Symbol b, Token token) {
        if (!inRange(token)) {
            return;
        }
        
        if (a.getName().equals("nothing")) {
            return;
        }
        
        if (b.getName().equals("nothing")) {
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
        
        if (symbol.getName().equals("nothing")) {
            return;
        }
        
        if (!this.validator.isNumber(symbol)) {
            addError(token, token.getText() + " is not a numeric expression");
        }
    }
    
    private void checkForValidExtendable(Symbol symbol, ParserRuleContext ctx) {
        if (!inRange(ctx.getStart())) {
            return;
        }
        
        if (symbol.getName().equals("nothing")) {
            return;
        }
        
        if (!this.validator.isStruct(symbol)) {
            addError(ctx.getStart(), "Struct or 'array' expected");
        }
    }
    
    private void checkForBoolean(Symbol symbol, ParserRuleContext ctx) {
        if (!inRange(ctx.getStart())) {
            return;
        }
        
        if (!this.validator.isBoolean(symbol)) {
            addError(ctx.getStart(), ctx.getText() + " is not a boolean expression");
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
    
    private void checkForValidCreateMethod(Symbol symbol, ParserRuleContext ctx) {
        if (!inRange(ctx.getStart())) {
            return;
        }
    
        if (symbol.getType() != symbol.getParent().getType()) {
            addError(
                ctx.getStart(),
                "Method create must return " + symbol.getParent().getName()
            );
        }
        
        if (!symbol.hasModifier(Modifier.STATIC)) {
            addError(
                ctx.getStart(),
                "Method create must be static"
            );
        }
    }
    
    private void checkForValidInitializer(Symbol symbol, ParserRuleContext ctx) {
        if (!inRange(ctx.getStart())) {
            return;
        }
        
        if (symbol.getName().equals("nothing")) {
            return;
        }
        
        checkForFunction(symbol, ctx);
        
        if (symbol instanceof ScopeSymbol) {
            if (!((ScopeSymbol) symbol).getParams().isEmpty()) {
                addError(ctx.getStart(), "Initializers must not take any parameters");
            }
            
            if (symbol.getParent().getSymbolType() == SymbolType.STRUCT) {
                if (!symbol.hasModifier(Modifier.STATIC)) {
                    addError(ctx.getStart(), "Initializers must be static");
                }
            }
        }
    }
    
    public boolean checkForValidMember(Symbol scope, Symbol member, ParserRuleContext ctx) {
        if (!member.canBeAccessBy(scope)) {
            addError(
                ctx.getStart(),
                String.format(
                    "Scope %s cannot access member %s",
                    scope.getName(),
                    member.getName()
                )
            );
            return false;
        }
        
        return true;
    }
    
    @Override
    public Symbol visitNativeDefinition(vrjParser.NativeDefinitionContext ctx) {
        return visit(ctx.functionSignature());
    }
    
    @Override
    public Symbol visitMemberExpression(vrjParser.MemberExpressionContext ctx) {
        Symbol prevScope = scope;
        boolean head = true;
        
        Resolution prevResolution;
        Symbol prevSymbol;
        
        Symbol symbol = null;
        
        for (vrjParser.MemberContext member : ctx.member()) {
            if (head) {
                symbol = visit(member);
                head = false;
            } else {
                prevSymbol = symbol;
                prevResolution = symbol.getResolution();
                
                if (symbol.getSymbolType() == SymbolType.STRUCT) {
                    symbol.setResolutionStrategy(new StaticMemberResolution());
                } else {
                    symbol.setResolutionStrategy(new NonStaticMemberResolution());
                }
                
                if (scope.getSymbolType() != SymbolType.STRUCT) {
                    scope = scope.getType();
                }
                
                symbol = visit(member);
                prevSymbol.setResolutionStrategy(prevResolution);
    
                if (!checkForValidMember(prevScope, symbol, member)) {
                    symbol = null;
                    break;
                }
            }
            
            scope = symbol;
        }
        
        if (symbol == null) {
            symbol = prevScope.resolve("nothing");
        }
        
        scope = prevScope;
        
        return symbol;
    }
    
    @Override
    public Symbol visitName(vrjParser.NameContext ctx) {
        Symbol symbol = super.visitName(ctx);
        checkForDefined(symbol, ctx);
        return symbol;
    }
    
    @Override
    public Symbol visitType(vrjParser.TypeContext ctx) {
        Symbol type = super.visitType(ctx);
        checkForValidType(type, ctx.getStart());
        return type;
    }
    
    @Override
    public Symbol visitGlobalVariable(vrjParser.GlobalVariableContext ctx) {
        return visit(ctx.variableStatement());
    }
    
    @Override
    public Symbol visitParenthesis(vrjParser.ParenthesisContext ctx) {
        return visit(ctx.expression());
    }
    
    @Override
    public Symbol visitNegative(vrjParser.NegativeContext ctx) {
        checkForNumeric(visit(ctx.expression()), ctx.expression().getStart());
        return super.visitNegative(ctx);
    }
    
    @Override
    public Symbol visitNot(vrjParser.NotContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression());
        return super.visitNot(ctx);
    }
    
    @Override
    public Symbol visitMod(vrjParser.ModContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return super.visitMod(ctx);
    }
    
    @Override
    public Symbol visitDiv(vrjParser.DivContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return super.visitDiv(ctx);
    }
    
    @Override
    public Symbol visitMult(vrjParser.MultContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return super.visitMult(ctx);
    }
    
    @Override
    public Symbol visitSum(vrjParser.SumContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return super.visitSum(ctx);
    }
    
    @Override
    public Symbol visitSub(vrjParser.SubContext ctx) {
        checkForNumeric(visit(ctx.expression(0)), ctx.expression(0).getStart());
        checkForNumeric(visit(ctx.expression(1)), ctx.expression(1).getStart());
        return super.visitSub(ctx);
    }
    
    @Override
    public Symbol visitVariableExpression(vrjParser.VariableExpressionContext ctx) {
        Symbol variable = visit(ctx.name());
        
        if (!inRange(ctx)) {
            return variable;
        }
    
        //checkForVariable(variable, ctx.name());
        
        if (ctx.expression() != null) {
            checkForNumeric(visit(ctx.expression()), ctx.expression().getStart());
        }
        
        return variable;
    }
    
    @Override
    public Symbol visitFunctionExpression(vrjParser.FunctionExpressionContext ctx) {
        Symbol function = visit(ctx.name());
        
        if (!inRange(ctx)) {
            return function;
        }
        
        //checkForFunction(function, ctx.name());
        
        if (this.validator.isFunction(function)) {
            ArrayList<Symbol> params = ((ScopeSymbol) function).getParams();
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
        
        return function;
    }
    
    @Override
    public Symbol visitComparison(vrjParser.ComparisonContext ctx) {
        Symbol a = visit(ctx.expression(0));
        Symbol b = visit(ctx.expression(1));
        
        switch (ctx.operator.getText()) {
            case "==":
            case "!=":
                checkForValidEqualityExpression(a, b, ctx);
                break;
            case ">":
            case ">=":
            case "<":
            case "<=":
                checkForValidSizeExpression(a, b, ctx);
                break;
        }
        
        return scope.resolve("boolean");
    }
    
    @Override
    public Symbol visitLogical(vrjParser.LogicalContext ctx) {
        checkForBoolean(visit(ctx.expression(0)), ctx.expression(0));
        checkForBoolean(visit(ctx.expression(1)), ctx.expression(1));
        return super.visitLogical(ctx);
    }
    
    @Override
    public Symbol visitCode(vrjParser.CodeContext ctx) {
        Symbol function = visit(ctx.name());
        
        checkForFunction(function, ctx.name());
        
        return super.visitCode(ctx);
    }
    
    @Override
    public Symbol visitParam(vrjParser.ParamContext ctx) {
        visit(ctx.type());
        return visit(ctx.name());
    }
    
    @Override
    public Symbol visitFunctionSignature(vrjParser.FunctionSignatureContext ctx) {
        Symbol function = visit(ctx.name());
        
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
        
        checkMissingReturn(function, ctx.statements());
        
        Symbol prevScope = scope;
        
        scope = function;
        visit(ctx.statements());
        scope = prevScope;
    
        return function;
    }
    
    @Override
    public Symbol visitFunctionCall(vrjParser.FunctionCallContext ctx) {
        Symbol function = visit(ctx.getChild(1));
        checkForFunction(function, (ParserRuleContext) ctx.getChild(1));
        return function;
    }
    
    @Override
    public Symbol visitVariableStatement(vrjParser.VariableStatementContext ctx) {
        Symbol variable = visit(ctx.name());
        
        visit(ctx.type());
        
        if (ctx.expression() != null) {
            if (variable.hasModifier(Modifier.ARRAY)) {
                addError(ctx.expression().getStart(), "Arrays can not be initialized (yet)");
            } else {
                Symbol value = visit(ctx.expression());
                checkCompatibleType(variable, value, ctx.expression().getStart());
            }
        }
        
        return variable;
    }
    
    @Override
    public Symbol visitSetVariable(vrjParser.SetVariableContext ctx) {
        Symbol variable = visit(ctx.getChild(1));
        
        if (variable.hasModifier(Modifier.CONSTANT)) {
            addError(((ParserRuleContext) ctx.getChild(1)).getStart(), "Cannot assign a value to constant variable");
        } else {
            checkCompatibleType(variable, visit(ctx.expression()), ctx.expression().getStart());
        }
        
        return variable;
    }
    
    @Override
    public Symbol visitExitwhen(vrjParser.ExitwhenContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression());
        return super.visitExitwhen(ctx);
    }
    
    @Override
    public Symbol visitIfStatement(vrjParser.IfStatementContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression());
        return super.visitIfStatement(ctx);
    }
    
    @Override
    public Symbol visitElseIfStatement(vrjParser.ElseIfStatementContext ctx) {
        checkForBoolean(visit(ctx.expression()), ctx.expression());
        return super.visitElseIfStatement(ctx);
    }
    
    @Override
    public Symbol visitReturnStatement(vrjParser.ReturnStatementContext ctx) {
        if (ctx.expression() != null) {
            Symbol value = visit(ctx.expression());
            checkCompatibleType(scope, value, ctx.expression().getStart());
            
            return value;
        } else if (scope.getType() != scope && scope.getType() != scope.resolve("nothing")) {
            addError(ctx.getStart(), "Must return a value");
        }
    
        return scope.resolve("nothing");
    }
    
    @Override
    public Symbol visitLibraryDefinition(vrjParser.LibraryDefinitionContext ctx) {
        Symbol library = visit(ctx.name(0));
        
        Symbol prevScope = scope;
        scope = library;
        
        if (ctx.initializer != null) {
            Symbol initializer = visit(ctx.initializer);
            
            checkForValidInitializer(initializer, ctx.initializer);
            
            if (library instanceof ScopeSymbol) {
                ((ScopeSymbol) library).setInitializer(initializer);
            }
        }
        
        if (ctx.libraryRequirementExpression() != null) {
            for (vrjParser.NameContext requirement : ctx.libraryRequirementExpression().name()) {
                checkLibraryRequirement(visit(requirement), requirement);
            }
        }
        
        visit(ctx.libraryBody());
        scope = prevScope;
        
        return library;
    }
    
    @Override
    public Symbol visitStructDefinition(vrjParser.StructDefinitionContext ctx) {
        Symbol struct = visit(ctx.name());
        
        if (ctx.extendsFrom != null) {
            if (ctx.extendsFrom.getText().equals("array")) {
                
            } else {
                Symbol extend = visit(ctx.extendsFrom);
                
                checkForValidExtendable(extend, ctx.extendsFrom);
                struct.addExtends(extend);
            }
        }
        
        Symbol prevScope = scope;
        
        scope = struct;
        visit(ctx.structBody());
        scope = prevScope;
        
        return struct;
    }
    
    @Override
    public Symbol visitPropertyStatement(vrjParser.PropertyStatementContext ctx) {
        Symbol property = visit(ctx.variableStatement());
        super.visitPropertyStatement(ctx);
        return property;
    }
    
    @Override
    public Symbol visitMethodDefinition(vrjParser.MethodDefinitionContext ctx) {
        Symbol method = visit(ctx.functionSignature());
    
        if ("onInit".equals(method.getName())) {
            checkForValidInitializer(method, ctx.functionSignature());
            
            if (scope instanceof ScopeSymbol) {
                ((ScopeSymbol) scope).setInitializer(method);
            }
        } else if ("create".equals(method.getName())) {
            checkForValidCreateMethod(method, ctx.functionSignature());
        }
        
        scope = method;
        visit(ctx.statements());
        scope = method.getParent();
        
        return method;
    }
}
