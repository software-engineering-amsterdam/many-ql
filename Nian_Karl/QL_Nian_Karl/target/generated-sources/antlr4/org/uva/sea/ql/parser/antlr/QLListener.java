// Generated from QL.g4 by ANTLR 4.4
package org.uva.sea.ql.parser.antlr;

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.form.*;

import org.antlr.v4.runtime.misc.NotNull;
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
	void enterNumber(@NotNull QLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull QLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlusExpr}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(@NotNull QLParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlusExpr}
	 * labeled alternative in {@link QLParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(@NotNull QLParser.PlusExprContext ctx);
}