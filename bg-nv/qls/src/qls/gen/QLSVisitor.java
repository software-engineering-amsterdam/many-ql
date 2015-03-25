// Generated from D:/intellij_projects/many-ql/bg-nv/qls/src/qls/syntax\QLS.g4 by ANTLR 4.5
package qls.gen;
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
	 * Visit a parse tree produced by {@link QLSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLSParser.StatementContext ctx);
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
	 * Visit a parse tree produced by {@link QLSParser#defaultStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStmt(@NotNull QLSParser.DefaultStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#stylesheetRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheetRule(@NotNull QLSParser.StylesheetRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLSParser#widgetValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidgetValue(@NotNull QLSParser.WidgetValueContext ctx);
}