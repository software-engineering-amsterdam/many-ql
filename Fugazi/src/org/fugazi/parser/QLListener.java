// Generated from /Users/lukaszharezlak/Projects/uva_software_construction/many-ql/Fugazi/src/org/fugazi/grammar/QL.g4 by ANTLR 4.5
package org.fugazi.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stamentQuestoinDeclaration}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStamentQuestoinDeclaration(@NotNull QLParser.StamentQuestoinDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stamentQuestoinDeclaration}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStamentQuestoinDeclaration(@NotNull QLParser.StamentQuestoinDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stamentifStatement}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStamentifStatement(@NotNull QLParser.StamentifStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stamentifStatement}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStamentifStatement(@NotNull QLParser.StamentifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull QLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull QLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noAssignmentQuestion}
	 * labeled alternative in {@link QLParser#questionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noAssignmentQuestion}
	 * labeled alternative in {@link QLParser#questionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentQuestion}
	 * labeled alternative in {@link QLParser#questionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentQuestion}
	 * labeled alternative in {@link QLParser#questionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull QLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull QLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumber}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumber(@NotNull QLParser.ExpressionNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumber}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumber(@NotNull QLParser.ExpressionNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketedExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBracketedExpression(@NotNull QLParser.BracketedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketedExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBracketedExpression(@NotNull QLParser.BracketedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionId}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionId(@NotNull QLParser.ExpressionIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionId}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionId(@NotNull QLParser.ExpressionIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negation}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegation(@NotNull QLParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegation(@NotNull QLParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedExpression}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterNestedExpression(@NotNull QLParser.NestedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedExpression}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitNestedExpression(@NotNull QLParser.NestedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOr}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(@NotNull QLParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOr}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(@NotNull QLParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalNumber}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNumber(@NotNull QLParser.LogicalNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNumber}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNumber(@NotNull QLParser.LogicalNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalId}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalId(@NotNull QLParser.LogicalIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalId}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalId(@NotNull QLParser.LogicalIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(@NotNull QLParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(@NotNull QLParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAnd}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(@NotNull QLParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAnd}
	 * labeled alternative in {@link QLParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(@NotNull QLParser.LogicalAndContext ctx);
}