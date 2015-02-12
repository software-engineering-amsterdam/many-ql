// Generated from /Users/Sugar/Documents/Msc/Software-Construction/many-ql/Fugazi/src/org/fugazi/grammar/QL.g4 by ANTLR 4.5
package org.fugazi.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull QLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noAssignmentQuestion}
	 * labeled alternative in {@link QLParser#questionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentQuestion}
	 * labeled alternative in {@link QLParser#questionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull QLParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moneyType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoneyType(@NotNull QLParser.MoneyTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull QLParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(@NotNull QLParser.ParenthesisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExpression(@NotNull QLParser.SingleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(@NotNull QLParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx);
}