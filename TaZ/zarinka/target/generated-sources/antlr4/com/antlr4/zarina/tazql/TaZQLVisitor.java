// Generated from TaZQL.g4 by ANTLR 4.4
package com.antlr4.zarina.tazql;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TaZQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TaZQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#formId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormId(@NotNull TaZQLParser.FormIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#answerId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerId(@NotNull TaZQLParser.AnswerIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#questionId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionId(@NotNull TaZQLParser.QuestionIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull TaZQLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull TaZQLParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#formSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormSection(@NotNull TaZQLParser.FormSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull TaZQLParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull TaZQLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#choise}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoise(@NotNull TaZQLParser.ChoiseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#questionLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(@NotNull TaZQLParser.QuestionLabelContext ctx);
}