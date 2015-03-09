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
	 * Visit a parse tree produced by the {@code slider}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlider(@NotNull QLSParser.SliderContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#font}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFont(@NotNull QLSParser.FontContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull QLSParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropdown}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropdown(@NotNull QLSParser.DropdownContext ctx);
	/**
	 * Visit a parse tree produced by the {@code spinbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpinbox(@NotNull QLSParser.SpinboxContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(@NotNull QLSParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextbox(@NotNull QLSParser.TextboxContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#pageBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPageBlock(@NotNull QLSParser.PageBlockContext ctx);
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
	 * Visit a parse tree produced by the {@code checkbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckbox(@NotNull QLSParser.CheckboxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code radio}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadio(@NotNull QLSParser.RadioContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull QLSParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#styling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyling(@NotNull QLSParser.StylingContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#sheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSheet(@NotNull QLSParser.SheetContext ctx);
}