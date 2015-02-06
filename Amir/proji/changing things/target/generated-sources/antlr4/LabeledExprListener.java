// Generated from LabeledExpr.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LabeledExprParser}.
 */
public interface LabeledExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull LabeledExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull LabeledExprParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull LabeledExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull LabeledExprParser.AssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull LabeledExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull LabeledExprParser.ProgContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#blank}.
	 * @param ctx the parse tree
	 */
	void enterBlank(@NotNull LabeledExprParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#blank}.
	 * @param ctx the parse tree
	 */
	void exitBlank(@NotNull LabeledExprParser.BlankContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(@NotNull LabeledExprParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(@NotNull LabeledExprParser.PrintExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull LabeledExprParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull LabeledExprParser.IntContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#AddSub}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(@NotNull LabeledExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#AddSub}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(@NotNull LabeledExprParser.AddSubContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#parens}.
	 * @param ctx the parse tree
	 */
	void enterParens(@NotNull LabeledExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#parens}.
	 * @param ctx the parse tree
	 */
	void exitParens(@NotNull LabeledExprParser.ParensContext ctx);

	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#MulDiv}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(@NotNull LabeledExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#MulDiv}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(@NotNull LabeledExprParser.MulDivContext ctx);
}