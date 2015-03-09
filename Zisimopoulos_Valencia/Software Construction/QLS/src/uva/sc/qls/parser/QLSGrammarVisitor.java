// Generated from QLSGrammar.g4 by ANTLR 4.5
 package uva.sc.qls.parser; 
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLSGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLSGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(QLSGrammarParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(QLSGrammarParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(QLSGrammarParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#sectionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionBody(QLSGrammarParser.SectionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QLSGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#widget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidget(QLSGrammarParser.WidgetContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#defaultStyle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStyle(QLSGrammarParser.DefaultStyleContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#styleProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleProperty(QLSGrammarParser.StylePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(QLSGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSGrammarParser#widgetType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidgetType(QLSGrammarParser.WidgetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(QLSGrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(QLSGrammarParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(QLSGrammarParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(QLSGrammarParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colorencode}
	 * labeled alternative in {@link QLSGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorencode(QLSGrammarParser.ColorencodeContext ctx);
}