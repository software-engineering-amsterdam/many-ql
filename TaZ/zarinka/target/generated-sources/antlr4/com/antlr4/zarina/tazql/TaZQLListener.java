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
	 * Enter a parse tree produced by {@link TaZQLParser#formId}.
	 * @param ctx the parse tree
	 */
	void enterFormId(@NotNull TaZQLParser.FormIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#formId}.
	 * @param ctx the parse tree
	 */
	void exitFormId(@NotNull TaZQLParser.FormIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#answerId}.
	 * @param ctx the parse tree
	 */
	void enterAnswerId(@NotNull TaZQLParser.AnswerIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#answerId}.
	 * @param ctx the parse tree
	 */
	void exitAnswerId(@NotNull TaZQLParser.AnswerIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#questionId}.
	 * @param ctx the parse tree
	 */
	void enterQuestionId(@NotNull TaZQLParser.QuestionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#questionId}.
	 * @param ctx the parse tree
	 */
	void exitQuestionId(@NotNull TaZQLParser.QuestionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull TaZQLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull TaZQLParser.FormContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#choise}.
	 * @param ctx the parse tree
	 */
	void enterChoise(@NotNull TaZQLParser.ChoiseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#choise}.
	 * @param ctx the parse tree
	 */
	void exitChoise(@NotNull TaZQLParser.ChoiseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void enterQuestionLabel(@NotNull TaZQLParser.QuestionLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void exitQuestionLabel(@NotNull TaZQLParser.QuestionLabelContext ctx);
}