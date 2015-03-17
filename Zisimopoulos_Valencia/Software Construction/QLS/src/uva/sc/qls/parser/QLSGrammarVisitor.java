// Generated from QLSGrammar.g4 by ANTLR 4.5
package uva.sc.qls.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLSGrammarParser}.
 *
 * @param <T>
 *            The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface QLSGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#stylesheet}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(QLSGrammarParser.StylesheetContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#page}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitPage(QLSGrammarParser.PageContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#section}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitSection(QLSGrammarParser.SectionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#sectionBody}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitSectionBody(QLSGrammarParser.SectionBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#question}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QLSGrammarParser.QuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#widget}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitWidget(QLSGrammarParser.WidgetContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#defaultStyle}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStyle(QLSGrammarParser.DefaultStyleContext ctx);

	/**
	 * Visit a parse tree produced by the {@code width} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitWidth(QLSGrammarParser.WidthContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fontName} labeled alternative
	 * in {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFontName(QLSGrammarParser.FontNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fontsize} labeled alternative
	 * in {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFontsize(QLSGrammarParser.FontsizeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code color} labeled alternative in
	 * {@link QLSGrammarParser#styleProperty}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitColor(QLSGrammarParser.ColorContext ctx);

	/**
	 * Visit a parse tree produced by the {@code boolean} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(QLSGrammarParser.BooleanContext ctx);

	/**
	 * Visit a parse tree produced by the {@code number} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitNumber(QLSGrammarParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by the {@code string} labeled alternative in
	 * {@link QLSGrammarParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitString(QLSGrammarParser.StringContext ctx);

	/**
	 * Visit a parse tree produced by the {@code checkbox} labeled alternative
	 * in {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitCheckbox(QLSGrammarParser.CheckboxContext ctx);

	/**
	 * Visit a parse tree produced by the {@code spinbox} labeled alternative in
	 * {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitSpinbox(QLSGrammarParser.SpinboxContext ctx);

	/**
	 * Visit a parse tree produced by the {@code radio} labeled alternative in
	 * {@link QLSGrammarParser#widgetType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitRadio(QLSGrammarParser.RadioContext ctx);

	/**
	 * Visit a parse tree produced by the {@code arial} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitArial(QLSGrammarParser.ArialContext ctx);

	/**
	 * Visit a parse tree produced by the {@code timesNewRoman} labeled
	 * alternative in {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitTimesNewRoman(QLSGrammarParser.TimesNewRomanContext ctx);

	/**
	 * Visit a parse tree produced by the {@code bazooka} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitBazooka(QLSGrammarParser.BazookaContext ctx);

	/**
	 * Visit a parse tree produced by the {@code bookAntiqua} labeled
	 * alternative in {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitBookAntiqua(QLSGrammarParser.BookAntiquaContext ctx);

	/**
	 * Visit a parse tree produced by the {@code courier} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitCourier(QLSGrammarParser.CourierContext ctx);

	/**
	 * Visit a parse tree produced by the {@code dialog} labeled alternative in
	 * {@link QLSGrammarParser#font}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitDialog(QLSGrammarParser.DialogContext ctx);
}