// Generated from QLbk.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLbkParser}.
 */
public interface QLbkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLbkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull QLbkParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull QLbkParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull QLbkParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull QLbkParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QLbkParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QLbkParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#questionName}.
	 * @param ctx the parse tree
	 */
	void enterQuestionName(@NotNull QLbkParser.QuestionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#questionName}.
	 * @param ctx the parse tree
	 */
	void exitQuestionName(@NotNull QLbkParser.QuestionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(@NotNull QLbkParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(@NotNull QLbkParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(@NotNull QLbkParser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(@NotNull QLbkParser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull QLbkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull QLbkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(@NotNull QLbkParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(@NotNull QLbkParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QLbkParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QLbkParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void enterQuestionLabel(@NotNull QLbkParser.QuestionLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void exitQuestionLabel(@NotNull QLbkParser.QuestionLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull QLbkParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull QLbkParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#userType}.
	 * @param ctx the parse tree
	 */
	void enterUserType(@NotNull QLbkParser.UserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#userType}.
	 * @param ctx the parse tree
	 */
	void exitUserType(@NotNull QLbkParser.UserTypeContext ctx);
}