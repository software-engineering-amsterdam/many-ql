// Generated from QL.g4 by ANTLR 4.5

package org.uva.sea.ql.parser.antlr;
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
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(QLParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusExpr}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(QLParser.PlusExprContext ctx);
}