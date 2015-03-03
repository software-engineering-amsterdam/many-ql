// Generated from QLS.g4 by ANTLR 4.5

	package uva.qls.parser;

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
	 * Visit a parse tree produced by the {@code CtxComponenet}
	 * labeled alternative in {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxComponenet(QLSParser.CtxComponenetContext ctx);
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
	 * Visit a parse tree produced by {@link QLSParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(QLSParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(QLSParser.ComponentContext ctx);
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
	 * Visit a parse tree produced by {@link QLSParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(QLSParser.PrimitiveTypeContext ctx);
}