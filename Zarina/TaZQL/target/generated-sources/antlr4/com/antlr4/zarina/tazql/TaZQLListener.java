// Generated from TaZQL.g4 by ANTLR 4.4
package com.antlr4.zarina.tazql;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TaZQLParser}.
 */
public interface TaZQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#simpleQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#simpleQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull TaZQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull TaZQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#computedQuestion}.
	 * @param ctx the parse tree
	 */
	void enterComputedQuestion(@NotNull TaZQLParser.ComputedQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#computedQuestion}.
	 * @param ctx the parse tree
	 */
	void exitComputedQuestion(@NotNull TaZQLParser.ComputedQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull TaZQLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull TaZQLParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#formSection}.
	 * @param ctx the parse tree
	 */
	void enterFormSection(@NotNull TaZQLParser.FormSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#formSection}.
	 * @param ctx the parse tree
	 */
	void exitFormSection(@NotNull TaZQLParser.FormSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull TaZQLParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull TaZQLParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull TaZQLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull TaZQLParser.TypeContext ctx);
}