// Generated from /Users/lukaszharezlak/Projects/uva_software_construction/many-ql/Fugazi/src/org/fugazi/grammar/ql.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link qlParser}.
 */
public interface qlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link qlParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull qlParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull qlParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull qlParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull qlParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull qlParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull qlParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull qlParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull qlParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull qlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull qlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expression(@NotNull qlParser.Logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expression(@NotNull qlParser.Logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull qlParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull qlParser.IdContext ctx);
}