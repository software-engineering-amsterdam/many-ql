// Generated from F:/UvA/SE/Software Construction/many-ql/kennedy-langlotz/KLQ/src\KLQ.g4 by ANTLR 4.5
package com.klq.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KLQParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KLQVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KLQParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(@NotNull KLQParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull KLQParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#condQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondQuestion(@NotNull KLQParser.CondQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#uncondQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUncondQuestion(@NotNull KLQParser.UncondQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(@NotNull KLQParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull KLQParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull KLQParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(@NotNull KLQParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(@NotNull KLQParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(@NotNull KLQParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparators}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparators(@NotNull KLQParser.ComparatorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull KLQParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull KLQParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull KLQParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Date}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(@NotNull KLQParser.DateContext ctx);
}