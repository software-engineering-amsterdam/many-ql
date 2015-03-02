// Generated from /home/alex/Develop/Msc/many-ql/Fugazi/src/org/fugazi/qls/grammar/QLS.g4 by ANTLR 4.5
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
	 * Visit a parse tree produced by the {@code checkboxWidget}
	 * labeled alternative in {@link QLSParser#widgets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckboxWidget(@NotNull QLSParser.CheckboxWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code radioWidget}
	 * labeled alternative in {@link QLSParser#widgets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadioWidget(@NotNull QLSParser.RadioWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropdownWidget}
	 * labeled alternative in {@link QLSParser#widgets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropdownWidget(@NotNull QLSParser.DropdownWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code spinboxWidget}
	 * labeled alternative in {@link QLSParser#widgets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpinboxWidget(@NotNull QLSParser.SpinboxWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sliderWidget}
	 * labeled alternative in {@link QLSParser#widgets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliderWidget(@NotNull QLSParser.SliderWidgetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textWidget}
	 * labeled alternative in {@link QLSParser#widgets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextWidget(@NotNull QLSParser.TextWidgetContext ctx);
}