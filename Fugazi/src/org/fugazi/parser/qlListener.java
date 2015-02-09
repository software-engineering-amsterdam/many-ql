// Generated from /Users/lukaszharezlak/Projects/uva_software_construction/many-ql/Fugazi/src/org/fugazi/grammar/ql.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link qlParser}.
 */
public interface qlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link qlParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull qlParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull qlParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull qlParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull qlParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull qlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull qlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(@NotNull qlParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(@NotNull qlParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#display}.
	 * @param ctx the parse tree
	 */
	void enterDisplay(@NotNull qlParser.DisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#display}.
	 * @param ctx the parse tree
	 */
	void exitDisplay(@NotNull qlParser.DisplayContext ctx);
}