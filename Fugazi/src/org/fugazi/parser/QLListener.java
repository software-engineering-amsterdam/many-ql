// Generated from /Users/Sugar/Documents/Msc/Software-Construction/many-ql/Fugazi/src/org/fugazi/grammar/QL.g4 by ANTLR 4.5
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
	 * Enter a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull QLParser.StatementContext ctx);
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
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull QLParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull QLParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moneyType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMoneyType(@NotNull QLParser.MoneyTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moneyType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMoneyType(@NotNull QLParser.MoneyTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull QLParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull QLParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(@NotNull QLParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(@NotNull QLParser.ParenthesisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleExpression(@NotNull QLParser.SingleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleExpression(@NotNull QLParser.SingleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(@NotNull QLParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(@NotNull QLParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx);
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
}