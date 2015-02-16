// Generated from /home/juriaan/Development/IdeaProjects/many-ql/kennedy-langlotz/src/com/klq/lang/KLQ.g4 by ANTLR 4.5
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KLQParser}.
 */
public interface KLQListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KLQParser#questionaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionaire(@NotNull KLQParser.QuestionaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#questionaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionaire(@NotNull KLQParser.QuestionaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull KLQParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull KLQParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#questionBegin}.
	 * @param ctx the parse tree
	 */
	void enterQuestionBegin(@NotNull KLQParser.QuestionBeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#questionBegin}.
	 * @param ctx the parse tree
	 */
	void exitQuestionBegin(@NotNull KLQParser.QuestionBeginContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#questionEnd}.
	 * @param ctx the parse tree
	 */
	void enterQuestionEnd(@NotNull KLQParser.QuestionEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#questionEnd}.
	 * @param ctx the parse tree
	 */
	void exitQuestionEnd(@NotNull KLQParser.QuestionEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterSpecification(@NotNull KLQParser.SpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitSpecification(@NotNull KLQParser.SpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(@NotNull KLQParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(@NotNull KLQParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(@NotNull KLQParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(@NotNull KLQParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull KLQParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull KLQParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#answerSet}.
	 * @param ctx the parse tree
	 */
	void enterAnswerSet(@NotNull KLQParser.AnswerSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#answerSet}.
	 * @param ctx the parse tree
	 */
	void exitAnswerSet(@NotNull KLQParser.AnswerSetContext ctx);
}