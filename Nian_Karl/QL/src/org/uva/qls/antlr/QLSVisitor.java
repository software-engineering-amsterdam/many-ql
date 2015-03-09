// Generated from QLS.g4 by ANTLR 4.4
package org.uva.qls.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle(@NotNull QLSParser.StyleContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(@NotNull QLSParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#font}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFont(@NotNull QLSParser.FontContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#trueFalseIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseIdentifier(@NotNull QLSParser.TrueFalseIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull QLSParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#questionIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionIdent(@NotNull QLSParser.QuestionIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidget(@NotNull QLSParser.WidgetContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#styling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyling(@NotNull QLSParser.StylingContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(@NotNull QLSParser.SectionContext ctx);
}