// Generated from QLbk.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLbkParser}.
 */
public interface QLbkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLbkParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(QLbkParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(QLbkParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QLbkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QLbkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(QLbkParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(QLbkParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLbkParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLbkParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(QLbkParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(QLbkParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(QLbkParser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(QLbkParser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#userType}.
	 * @param ctx the parse tree
	 */
	void enterUserType(QLbkParser.UserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#userType}.
	 * @param ctx the parse tree
	 */
	void exitUserType(QLbkParser.UserTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#questionName}.
	 * @param ctx the parse tree
	 */
	void enterQuestionName(QLbkParser.QuestionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#questionName}.
	 * @param ctx the parse tree
	 */
	void exitQuestionName(QLbkParser.QuestionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void enterQuestionLabel(QLbkParser.QuestionLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void exitQuestionLabel(QLbkParser.QuestionLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(QLbkParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(QLbkParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(QLbkParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(QLbkParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLbkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(QLbkParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLbkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(QLbkParser.LiteralContext ctx);
}