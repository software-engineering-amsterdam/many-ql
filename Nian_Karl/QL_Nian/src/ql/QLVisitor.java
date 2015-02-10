// Generated from QL.g4 by ANTLR 4.5
package ql;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(QLParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(QLParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(QLParser.ExprContext ctx);
}