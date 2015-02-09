// Generated from QL.g4 by ANTLR 4.5

package org.uva.sea.ql.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterNumber(QLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitNumber(QLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlusExpr}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(QLParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlusExpr}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(QLParser.PlusExprContext ctx);
}