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
	 * Enter a parse tree produced by {@link qlParser#ifstat}.
	 * @param ctx the parse tree
	 */
	void enterIfstat(@NotNull qlParser.IfstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#ifstat}.
	 * @param ctx the parse tree
	 */
	void exitIfstat(@NotNull qlParser.IfstatContext ctx);
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
	 * Enter a parse tree produced by {@link qlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull qlParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull qlParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link qlParser#assignee}.
	 * @param ctx the parse tree
	 */
	void enterAssignee(@NotNull qlParser.AssigneeContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlParser#assignee}.
	 * @param ctx the parse tree
	 */
	void exitAssignee(@NotNull qlParser.AssigneeContext ctx);
}