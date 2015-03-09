// Generated from QLSGrammar.g4 by ANTLR 4.5
 package uva.sc.qls.parser; 
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLSGrammarParser}.
 */
public interface QLSGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(QLSGrammarParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(QLSGrammarParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(QLSGrammarParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(QLSGrammarParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QLSGrammarParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QLSGrammarParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#sectionBody}.
	 * @param ctx the parse tree
	 */
	void enterSectionBody(QLSGrammarParser.SectionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#sectionBody}.
	 * @param ctx the parse tree
	 */
	void exitSectionBody(QLSGrammarParser.SectionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLSGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLSGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterWidget(QLSGrammarParser.WidgetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitWidget(QLSGrammarParser.WidgetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#defaultStyle}.
	 * @param ctx the parse tree
	 */
	void enterDefaultStyle(QLSGrammarParser.DefaultStyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#defaultStyle}.
	 * @param ctx the parse tree
	 */
	void exitDefaultStyle(QLSGrammarParser.DefaultStyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#styleProperty}.
	 * @param ctx the parse tree
	 */
	void enterStyleProperty(QLSGrammarParser.StylePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#styleProperty}.
	 * @param ctx the parse tree
	 */
	void exitStyleProperty(QLSGrammarParser.StylePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(QLSGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(QLSGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterWidgetType(QLSGrammarParser.WidgetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitWidgetType(QLSGrammarParser.WidgetTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumber(QLSGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumber(QLSGrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(QLSGrammarParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(QLSGrammarParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterId(QLSGrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitId(QLSGrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterString(QLSGrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitString(QLSGrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colorencode}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterColorencode(QLSGrammarParser.ColorencodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colorencode}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitColorencode(QLSGrammarParser.ColorencodeContext ctx);
}