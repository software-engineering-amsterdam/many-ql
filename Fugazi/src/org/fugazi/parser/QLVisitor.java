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
	 * Visit a parse tree produced by the {@code stamentQuestoinDeclaration}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStamentQuestoinDeclaration(@NotNull QLParser.StamentQuestoinDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stamentifStatement}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStamentifStatement(@NotNull QLParser.StamentifStatementContext ctx);
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
	 * Visit a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull QLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumber}
	 * labeled alternative in {@link QLParser#numericalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumber(@NotNull QLParser.ExpressionNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketedExpression}
	 * labeled alternative in {@link QLParser#numericalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketedExpression(@NotNull QLParser.BracketedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionId}
	 * labeled alternative in {@link QLParser#numericalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionId(@NotNull QLParser.ExpressionIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link QLParser#numericalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpression}
	 * labeled alternative in {@link QLParser#numericalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(@NotNull QLParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nestedExpression}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedExpression(@NotNull QLParser.NestedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOr}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(@NotNull QLParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalNumber}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalNumber(@NotNull QLParser.LogicalNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalId}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalId(@NotNull QLParser.LogicalIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull QLParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAnd}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(@NotNull QLParser.LogicalAndContext ctx);
}