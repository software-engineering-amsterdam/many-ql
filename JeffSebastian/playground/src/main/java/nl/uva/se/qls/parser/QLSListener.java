// Generated from QLS.g4 by ANTLR 4.5

package nl.uva.se.qls.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLSParser}.
 */
public interface QLSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(QLSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(QLSParser.StylesheetContext ctx);
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
	 * Enter a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLSParser.QuestionContext ctx);
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
	 * Enter a parse tree produced by {@link QLSParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(QLSParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(QLSParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#styleRule}.
	 * @param ctx the parse tree
	 */
	void enterStyleRule(QLSParser.StyleRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#styleRule}.
	 * @param ctx the parse tree
	 */
	void exitStyleRule(QLSParser.StyleRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterWidgetType(QLSParser.WidgetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitWidgetType(QLSParser.WidgetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#radio}.
	 * @param ctx the parse tree
	 */
	void enterRadio(QLSParser.RadioContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#radio}.
	 * @param ctx the parse tree
	 */
	void exitRadio(QLSParser.RadioContext ctx);
}