// Generated from QL.g4 by ANTLR 4.4
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
	/**
	 * Enter a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 */
	void enterQuestionName(@NotNull QLParser.QuestionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 */
	void exitQuestionName(@NotNull QLParser.QuestionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(@NotNull QLParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(@NotNull QLParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(@NotNull QLParser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(@NotNull QLParser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull QLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull QLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(@NotNull QLParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(@NotNull QLParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void enterQuestionLabel(@NotNull QLParser.QuestionLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void exitQuestionLabel(@NotNull QLParser.QuestionLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull QLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull QLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#userType}.
	 * @param ctx the parse tree
	 */
	void enterUserType(@NotNull QLParser.UserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#userType}.
	 * @param ctx the parse tree
	 */
	void exitUserType(@NotNull QLParser.UserTypeContext ctx);
}