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
	 * Enter a parse tree produced by {@link QLSParser#pageBlock}.
	 * @param ctx the parse tree
	 */
	void enterPageBlock(@NotNull QLSParser.PageBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#pageBlock}.
	 * @param ctx the parse tree
	 */
	void exitPageBlock(@NotNull QLSParser.PageBlockContext ctx);
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
	 * Enter a parse tree produced by {@link QLSParser#intWidgetParam}.
	 * @param ctx the parse tree
	 */
	void enterIntWidgetParam(@NotNull QLSParser.IntWidgetParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#intWidgetParam}.
	 * @param ctx the parse tree
	 */
	void exitIntWidgetParam(@NotNull QLSParser.IntWidgetParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QLSParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QLSParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull QLSParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull QLSParser.TypeContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link QLSParser#sheet}.
	 * @param ctx the parse tree
	 */
	void enterSheet(@NotNull QLSParser.SheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#sheet}.
	 * @param ctx the parse tree
	 */
	void exitSheet(@NotNull QLSParser.SheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#boolWidgetParam}.
	 * @param ctx the parse tree
	 */
	void enterBoolWidgetParam(@NotNull QLSParser.BoolWidgetParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#boolWidgetParam}.
	 * @param ctx the parse tree
	 */
	void exitBoolWidgetParam(@NotNull QLSParser.BoolWidgetParamContext ctx);
}