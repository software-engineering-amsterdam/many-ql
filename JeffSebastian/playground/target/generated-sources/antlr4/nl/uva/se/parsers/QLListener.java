// Generated from QL.g4 by ANTLR 4.4

	package nl.uva.se.parsers;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull QLParser.ExpressionContext ctx);
}