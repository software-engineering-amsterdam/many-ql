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
	 * Enter a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull QLParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull QLParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull QLParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull QLParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionDecl}.
	 * @param ctx the parse tree
	 */
	void enterQuestionDecl(@NotNull QLParser.QuestionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionDecl}.
	 * @param ctx the parse tree
	 */
	void exitQuestionDecl(@NotNull QLParser.QuestionDeclContext ctx);
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
	 * Enter a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expression(@NotNull QLParser.Logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expression(@NotNull QLParser.Logical_expressionContext ctx);
}