// Generated from QLSGrammar.g4 by ANTLR 4.5
package uva.sc.qls.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLSGrammarParser}.
 */
public interface QLSGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#stylesheet}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterStylesheet(QLSGrammarParser.StylesheetContext ctx);

	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#stylesheet}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitStylesheet(QLSGrammarParser.StylesheetContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#page}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterPage(QLSGrammarParser.PageContext ctx);

	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#page}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitPage(QLSGrammarParser.PageContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#section}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterSection(QLSGrammarParser.SectionContext ctx);

	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#section}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitSection(QLSGrammarParser.SectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#sectionBody}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterSectionBody(QLSGrammarParser.SectionBodyContext ctx);

	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#sectionBody}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitSectionBody(QLSGrammarParser.SectionBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#question}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterQuestion(QLSGrammarParser.QuestionContext ctx);

	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#question}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitQuestion(QLSGrammarParser.QuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#widget}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterWidget(QLSGrammarParser.WidgetContext ctx);

	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#widget}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitWidget(QLSGrammarParser.WidgetContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLSGrammarParser#defaultStyle}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterDefaultStyle(QLSGrammarParser.DefaultStyleContext ctx);

	/**
	 * Exit a parse tree produced by {@link QLSGrammarParser#defaultStyle}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitDefaultStyle(QLSGrammarParser.DefaultStyleContext ctx);

	/**
	 * Enter a parse tree produced by the {@code width} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterWidth(QLSGrammarParser.WidthContext ctx);

	/**
	 * Exit a parse tree produced by the {@code width} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitWidth(QLSGrammarParser.WidthContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fontName} labeled alternative
	 * in {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterFontName(QLSGrammarParser.FontNameContext ctx);

	/**
	 * Exit a parse tree produced by the {@code fontName} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitFontName(QLSGrammarParser.FontNameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fontsize} labeled alternative
	 * in {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterFontsize(QLSGrammarParser.FontsizeContext ctx);

	/**
	 * Exit a parse tree produced by the {@code fontsize} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitFontsize(QLSGrammarParser.FontsizeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code color} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterColor(QLSGrammarParser.ColorContext ctx);

	/**
	 * Exit a parse tree produced by the {@code color} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitColor(QLSGrammarParser.ColorContext ctx);

	/**
	 * Enter a parse tree produced by the {@code boolean} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterBoolean(QLSGrammarParser.BooleanContext ctx);

	/**
	 * Exit a parse tree produced by the {@code boolean} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitBoolean(QLSGrammarParser.BooleanContext ctx);

	/**
	 * Enter a parse tree produced by the {@code number} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterNumber(QLSGrammarParser.NumberContext ctx);

	/**
	 * Exit a parse tree produced by the {@code number} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitNumber(QLSGrammarParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by the {@code string} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterString(QLSGrammarParser.StringContext ctx);

	/**
	 * Exit a parse tree produced by the {@code string} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitString(QLSGrammarParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code checkbox} labeled alternative
	 * in {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterCheckbox(QLSGrammarParser.CheckboxContext ctx);

	/**
	 * Exit a parse tree produced by the {@code checkbox} labeled alternative in
	 * {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitCheckbox(QLSGrammarParser.CheckboxContext ctx);

	/**
	 * Enter a parse tree produced by the {@code spinbox} labeled alternative in
	 * {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterSpinbox(QLSGrammarParser.SpinboxContext ctx);

	/**
	 * Exit a parse tree produced by the {@code spinbox} labeled alternative in
	 * {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitSpinbox(QLSGrammarParser.SpinboxContext ctx);

	/**
	 * Enter a parse tree produced by the {@code radio} labeled alternative in
	 * {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterRadio(QLSGrammarParser.RadioContext ctx);

	/**
	 * Exit a parse tree produced by the {@code radio} labeled alternative in
	 * {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitRadio(QLSGrammarParser.RadioContext ctx);

	/**
	 * Enter a parse tree produced by the {@code arial} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterArial(QLSGrammarParser.ArialContext ctx);

	/**
	 * Exit a parse tree produced by the {@code arial} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitArial(QLSGrammarParser.ArialContext ctx);

	/**
	 * Enter a parse tree produced by the {@code timesNewRoman} labeled
	 * alternative in {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterTimesNewRoman(QLSGrammarParser.TimesNewRomanContext ctx);

	/**
	 * Exit a parse tree produced by the {@code timesNewRoman} labeled
	 * alternative in {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitTimesNewRoman(QLSGrammarParser.TimesNewRomanContext ctx);

	/**
	 * Enter a parse tree produced by the {@code bazooka} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterBazooka(QLSGrammarParser.BazookaContext ctx);

	/**
	 * Exit a parse tree produced by the {@code bazooka} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitBazooka(QLSGrammarParser.BazookaContext ctx);

	/**
	 * Enter a parse tree produced by the {@code bookAntiqua} labeled
	 * alternative in {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterBookAntiqua(QLSGrammarParser.BookAntiquaContext ctx);

	/**
	 * Exit a parse tree produced by the {@code bookAntiqua} labeled alternative
	 * in {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitBookAntiqua(QLSGrammarParser.BookAntiquaContext ctx);

	/**
	 * Enter a parse tree produced by the {@code courier} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterCourier(QLSGrammarParser.CourierContext ctx);

	/**
	 * Exit a parse tree produced by the {@code courier} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitCourier(QLSGrammarParser.CourierContext ctx);

	/**
	 * Enter a parse tree produced by the {@code dialog} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterDialog(QLSGrammarParser.DialogContext ctx);

	/**
	 * Exit a parse tree produced by the {@code dialog} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitDialog(QLSGrammarParser.DialogContext ctx);
}