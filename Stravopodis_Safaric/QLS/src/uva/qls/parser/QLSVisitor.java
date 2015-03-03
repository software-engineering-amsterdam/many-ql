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
	 * labeled alternative in {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxSection(QLSParser.CtxSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxSubsection}
	 * labeled alternative in {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxSubsection(QLSParser.CtxSubsectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxQuestion}
	 * labeled alternative in {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxQuestion(QLSParser.CtxQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxDefaultValue}
	 * labeled alternative in {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxDefaultValue(QLSParser.CtxDefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxComponent}
	 * labeled alternative in {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxComponent(QLSParser.CtxComponentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxStyle}
	 * labeled alternative in {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxStyle(QLSParser.CtxStyleContext ctx);
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
	 * Visit a parse tree produced by the {@code CtxDefaultComponent}
	 * labeled alternative in {@link QLSParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxDefaultComponent(QLSParser.CtxDefaultComponentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxDefaultStatement}
	 * labeled alternative in {@link QLSParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxDefaultStatement(QLSParser.CtxDefaultStatementContext ctx);
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
	 * Visit a parse tree produced by the {@code CtxRadio}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxRadio(QLSParser.CtxRadioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxCheckbox}
	 * labeled alternative in {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxCheckbox(QLSParser.CtxCheckboxContext ctx);
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
	 * Visit a parse tree produced by the {@code CtxBooleanLiteral}
	 * labeled alternative in {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxBooleanLiteral(QLSParser.CtxBooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxInteger}
	 * labeled alternative in {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxInteger(QLSParser.CtxIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxMoney}
	 * labeled alternative in {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxMoney(QLSParser.CtxMoneyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxPrimitiveBoolean}
	 * labeled alternative in {@link QLSParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxPrimitiveBoolean(QLSParser.CtxPrimitiveBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxPrimitiveMoney}
	 * labeled alternative in {@link QLSParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxPrimitiveMoney(QLSParser.CtxPrimitiveMoneyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxPrimitiveString}
	 * labeled alternative in {@link QLSParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxPrimitiveString(QLSParser.CtxPrimitiveStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxPrimitiveInteger}
	 * labeled alternative in {@link QLSParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxPrimitiveInteger(QLSParser.CtxPrimitiveIntegerContext ctx);
}