// Generated from E:/development/Steven/src/test/resources/antlr/grammars\QLS.g4 by ANTLR 4.5
package edu.parser.QLS.antlrGenerated;
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
	 * Visit a parse tree produced by {@link QLSParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull QLSParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLSParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#default_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault_statement(@NotNull QLSParser.Default_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#question_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_type(@NotNull QLSParser.Question_typeContext ctx);
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
	 * Visit a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle(@NotNull QLSParser.StyleContext ctx);
}