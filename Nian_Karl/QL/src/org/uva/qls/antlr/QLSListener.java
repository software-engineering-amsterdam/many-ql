// Generated from QLS.g4 by ANTLR 4.4
package org.uva.qls.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLSParser}.
 */
public interface QLSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(@NotNull QLSParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(@NotNull QLSParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(@NotNull QLSParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(@NotNull QLSParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#font}.
	 * @param ctx the parse tree
	 */
	void enterFont(@NotNull QLSParser.FontContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#font}.
	 * @param ctx the parse tree
	 */
	void exitFont(@NotNull QLSParser.FontContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#trueFalseIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseIdentifier(@NotNull QLSParser.TrueFalseIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#trueFalseIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseIdentifier(@NotNull QLSParser.TrueFalseIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull QLSParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull QLSParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#questionIdent}.
	 * @param ctx the parse tree
	 */
	void enterQuestionIdent(@NotNull QLSParser.QuestionIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#questionIdent}.
	 * @param ctx the parse tree
	 */
	void exitQuestionIdent(@NotNull QLSParser.QuestionIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterWidget(@NotNull QLSParser.WidgetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitWidget(@NotNull QLSParser.WidgetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#styling}.
	 * @param ctx the parse tree
	 */
	void enterStyling(@NotNull QLSParser.StylingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#styling}.
	 * @param ctx the parse tree
	 */
	void exitStyling(@NotNull QLSParser.StylingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(@NotNull QLSParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(@NotNull QLSParser.SectionContext ctx);
}