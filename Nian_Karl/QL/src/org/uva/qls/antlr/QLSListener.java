// Generated from QLS.g4 by ANTLR 4.5
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
	void enterStyle(QLSParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(QLSParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(QLSParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(QLSParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QLSParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QLSParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QLSParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QLSParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#questionIdent}.
	 * @param ctx the parse tree
	 */
	void enterQuestionIdent(QLSParser.QuestionIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#questionIdent}.
	 * @param ctx the parse tree
	 */
	void exitQuestionIdent(QLSParser.QuestionIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#styling}.
	 * @param ctx the parse tree
	 */
	void enterStyling(QLSParser.StylingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#styling}.
	 * @param ctx the parse tree
	 */
	void exitStyling(QLSParser.StylingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#font}.
	 * @param ctx the parse tree
	 */
	void enterFont(QLSParser.FontContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#font}.
	 * @param ctx the parse tree
	 */
	void exitFont(QLSParser.FontContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterWidget(QLSParser.WidgetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitWidget(QLSParser.WidgetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#trueFalseIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseIdentifier(QLSParser.TrueFalseIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#trueFalseIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseIdentifier(QLSParser.TrueFalseIdentifierContext ctx);
}