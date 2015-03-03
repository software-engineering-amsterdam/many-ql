// Generated from /Users/Sugar/Documents/Msc/Software-Construction/many-ql/Fugazi/src/org/fugazi/qls/grammar/QLS.g4 by ANTLR 4.5
package org.fugazi.qls.parser;
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
	 * Visit a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(@NotNull QLSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(@NotNull QLSParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(@NotNull QLSParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull QLSParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidget(@NotNull QLSParser.WidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noStylesDefaultDeclr}
	 * labeled alternative in {@link QLSParser#defaultStyleDeclr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoStylesDefaultDeclr(@NotNull QLSParser.NoStylesDefaultDeclrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stylesDefaultDeclr}
	 * labeled alternative in {@link QLSParser#defaultStyleDeclr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesDefaultDeclr(@NotNull QLSParser.StylesDefaultDeclrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkboxWidget}
	 * labeled alternative in {@link QLSParser#supportedWidget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckboxWidget(@NotNull QLSParser.CheckboxWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code radioWidget}
	 * labeled alternative in {@link QLSParser#supportedWidget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadioWidget(@NotNull QLSParser.RadioWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropdownWidget}
	 * labeled alternative in {@link QLSParser#supportedWidget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropdownWidget(@NotNull QLSParser.DropdownWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code spinboxWidget}
	 * labeled alternative in {@link QLSParser#supportedWidget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpinboxWidget(@NotNull QLSParser.SpinboxWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sliderWidget}
	 * labeled alternative in {@link QLSParser#supportedWidget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliderWidget(@NotNull QLSParser.SliderWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textWidget}
	 * labeled alternative in {@link QLSParser#supportedWidget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextWidget(@NotNull QLSParser.TextWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code widthStyleProperty}
	 * labeled alternative in {@link QLSParser#styleProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidthStyleProperty(@NotNull QLSParser.WidthStylePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fontStyleProperty}
	 * labeled alternative in {@link QLSParser#styleProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFontStyleProperty(@NotNull QLSParser.FontStylePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fontsizeStyleProperty}
	 * labeled alternative in {@link QLSParser#styleProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFontsizeStyleProperty(@NotNull QLSParser.FontsizeStylePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colorStyleProperty}
	 * labeled alternative in {@link QLSParser#styleProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorStyleProperty(@NotNull QLSParser.ColorStylePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull QLSParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull QLSParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(@NotNull QLSParser.StringTypeContext ctx);
}