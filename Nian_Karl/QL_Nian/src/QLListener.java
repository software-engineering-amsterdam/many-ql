// Generated from QL.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(QLParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(QLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(QLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(QLParser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(QLParser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#userType}.
	 * @param ctx the parse tree
	 */
	void enterUserType(QLParser.UserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#userType}.
	 * @param ctx the parse tree
	 */
	void exitUserType(QLParser.UserTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 */
	void enterQuestionName(QLParser.QuestionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 */
	void exitQuestionName(QLParser.QuestionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void enterQuestionLabel(QLParser.QuestionLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 */
	void exitQuestionLabel(QLParser.QuestionLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(QLParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(QLParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(QLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(QLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(QLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(QLParser.LiteralContext ctx);
}