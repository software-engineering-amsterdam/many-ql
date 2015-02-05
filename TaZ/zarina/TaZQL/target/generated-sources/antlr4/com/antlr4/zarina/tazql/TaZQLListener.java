// Generated from TaZQL.g4 by ANTLR 4.4
package com.antlr4.zarina.tazql;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TaZQLParser}.
 */
public interface TaZQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull TaZQLParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull TaZQLParser.RContext ctx);
}