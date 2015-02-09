// Generated from C:/Users/Timon/SkyDrive/MSc/Software Construction/many-ql/kennedy-langlotz/src\KLQ.g4 by ANTLR 4.5
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
	 * Enter a parse tree produced by {@link KLQParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(@NotNull KLQParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(@NotNull KLQParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#groupBegin}.
	 * @param ctx the parse tree
	 */
	void enterGroupBegin(@NotNull KLQParser.GroupBeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#groupBegin}.
	 * @param ctx the parse tree
	 */
	void exitGroupBegin(@NotNull KLQParser.GroupBeginContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#groupEnd}.
	 * @param ctx the parse tree
	 */
	void enterGroupEnd(@NotNull KLQParser.GroupEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#groupEnd}.
	 * @param ctx the parse tree
	 */
	void exitGroupEnd(@NotNull KLQParser.GroupEndContext ctx);
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
}