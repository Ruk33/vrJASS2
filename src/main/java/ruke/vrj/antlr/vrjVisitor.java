// Generated from C:/Users/Ruke/IntelliJ/vrj\vrj.g4 by ANTLR 4.5.3
package ruke.vrj.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link vrjParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface vrjVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link vrjParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(vrjParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(vrjParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(vrjParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(vrjParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(vrjParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(vrjParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#functionSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSignature(vrjParser.FunctionSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#nativeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeDefinition(vrjParser.NativeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(vrjParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#variableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(vrjParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(vrjParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Null}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(vrjParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(vrjParser.ModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(vrjParser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(vrjParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(vrjParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Code}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(vrjParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(vrjParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(vrjParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgnoreVariableExpression}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreVariableExpression(vrjParser.IgnoreVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(vrjParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(vrjParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative(vrjParser.NegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(vrjParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(vrjParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(vrjParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(vrjParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgnoreFunctionExpression}
	 * labeled alternative in {@link vrjParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreFunctionExpression(vrjParser.IgnoreFunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(vrjParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(vrjParser.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#globalDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalDefinition(vrjParser.GlobalDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(vrjParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#elseIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatement(vrjParser.ElseIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(vrjParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(vrjParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalVariable}
	 * labeled alternative in {@link vrjParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariable(vrjParser.LocalVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link vrjParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVariable(vrjParser.SetVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exitwhen}
	 * labeled alternative in {@link vrjParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitwhen(vrjParser.ExitwhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link vrjParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(vrjParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link vrjParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(vrjParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgnoreIf}
	 * labeled alternative in {@link vrjParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreIf(vrjParser.IgnoreIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgnoreLoop}
	 * labeled alternative in {@link vrjParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreLoop(vrjParser.IgnoreLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(vrjParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link vrjParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(vrjParser.FunctionDefinitionContext ctx);
}