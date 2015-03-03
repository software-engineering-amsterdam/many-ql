// Generated from QLS.g4 by ANTLR 4.5

	package uva.qls.parser;

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
	 * Visit a parse tree produced by {@link QLSParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(QLSParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(QLSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(QLSParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxSection}
	 * labeled alternative in {@link QLSParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxSection(QLSParser.CtxSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxSubsection}
	 * labeled alternative in {@link QLSParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxSubsection(QLSParser.CtxSubsectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxQuestion}
	 * labeled alternative in {@link QLSParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxQuestion(QLSParser.CtxQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxComponents}
	 * labeled alternative in {@link QLSParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxComponents(QLSParser.CtxComponentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(QLSParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#subsection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubsection(QLSParser.SubsectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(QLSParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxWidth}
	 * labeled alternative in {@link QLSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxWidth(QLSParser.CtxWidthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxHeight}
	 * labeled alternative in {@link QLSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxHeight(QLSParser.CtxHeightContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxFont}
	 * labeled alternative in {@link QLSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxFont(QLSParser.CtxFontContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxFontsize}
	 * labeled alternative in {@link QLSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxFontsize(QLSParser.CtxFontsizeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxColor}
	 * labeled alternative in {@link QLSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxColor(QLSParser.CtxColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#width}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidth(QLSParser.WidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#height}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeight(QLSParser.HeightContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#font}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFont(QLSParser.FontContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#fontsize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFontsize(QLSParser.FontsizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(QLSParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxTextbox}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxTextbox(QLSParser.CtxTextboxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxSpinbox}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxSpinbox(QLSParser.CtxSpinboxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxSlider}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxSlider(QLSParser.CtxSliderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxDropdown}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxDropdown(QLSParser.CtxDropdownContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxRadiobutton}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxRadiobutton(QLSParser.CtxRadiobuttonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxCheckbox}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxCheckbox(QLSParser.CtxCheckboxContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#textbox}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextbox(QLSParser.TextboxContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#spinbox}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpinbox(QLSParser.SpinboxContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#slider}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlider(QLSParser.SliderContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#dropdown}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropdown(QLSParser.DropdownContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#radiobutton}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadiobutton(QLSParser.RadiobuttonContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#checkbox}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckbox(QLSParser.CheckboxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(QLSParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(QLSParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(QLSParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(QLSParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(QLSParser.PrimitiveTypeContext ctx);
}