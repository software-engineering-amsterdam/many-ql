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
	 * Enter a parse tree produced by {@link QLSParser#sheet}.
	 * @param ctx the parse tree
	 */
	void enterSheet(QLSParser.SheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#sheet}.
	 * @param ctx the parse tree
	 */
	void exitSheet(QLSParser.SheetContext ctx);
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
	 * Enter a parse tree produced by {@link QLSParser#pageBlock}.
	 * @param ctx the parse tree
	 */
	void enterPageBlock(QLSParser.PageBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#pageBlock}.
	 * @param ctx the parse tree
	 */
	void exitPageBlock(QLSParser.PageBlockContext ctx);
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
	 * Enter a parse tree produced by {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(QLSParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(QLSParser.TypeContext ctx);
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
	 * Enter a parse tree produced by the {@code textbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterTextbox(QLSParser.TextboxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitTextbox(QLSParser.TextboxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code checkbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterCheckbox(QLSParser.CheckboxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code checkbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitCheckbox(QLSParser.CheckboxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code spinbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterSpinbox(QLSParser.SpinboxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code spinbox}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitSpinbox(QLSParser.SpinboxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slider}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterSlider(QLSParser.SliderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slider}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitSlider(QLSParser.SliderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropdown}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterDropdown(QLSParser.DropdownContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropdown}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitDropdown(QLSParser.DropdownContext ctx);
	/**
	 * Enter a parse tree produced by the {@code radio}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterRadio(QLSParser.RadioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code radio}
	 * labeled alternative in {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitRadio(QLSParser.RadioContext ctx);
}