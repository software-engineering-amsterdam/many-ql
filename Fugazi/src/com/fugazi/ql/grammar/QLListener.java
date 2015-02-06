// Generated from /Users/Sugar/Documents/Msc/Software-Construction/software-construction/2014-2015/Fugazi/src/com/fugazi/ql/grammar/QL.g4 by ANTLR 4.5
package com.fugazi.ql.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(@NotNull QLParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(@NotNull QLParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull QLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull QLParser.ValueContext ctx);
}