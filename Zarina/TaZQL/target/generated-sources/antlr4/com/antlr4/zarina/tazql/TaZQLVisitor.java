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
	 * Visit a parse tree produced by {@link TaZQLParser#simpleQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull TaZQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#computedQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedQuestion(@NotNull TaZQLParser.ComputedQuestionContext ctx);
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
}