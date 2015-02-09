// Generated from QL.g4 by ANTLR 4.5
package ql;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(QLParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(QLParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(QLParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(QLParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(QLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(QLParser.ExprContext ctx);
}