// Generated from /home/juriaan/Development/IdeaProjects/many-ql/kennedy-langlotz/src/KLQ.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KLQParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KLQVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KLQParser#questionaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionaire(@NotNull KLQParser.QuestionaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull KLQParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(@NotNull KLQParser.EndContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(@NotNull KLQParser.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(@NotNull KLQParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull KLQParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswers(@NotNull KLQParser.AnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(@NotNull KLQParser.QuestionTypeContext ctx);
}