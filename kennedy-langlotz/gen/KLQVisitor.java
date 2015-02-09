// Generated from C:/Users/Timon/SkyDrive/MSc/Software Construction/many-ql/kennedy-langlotz/src\KLQ.g4 by ANTLR 4.5
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
	 * Visit a parse tree produced by {@link KLQParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(@NotNull KLQParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#groupBegin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupBegin(@NotNull KLQParser.GroupBeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#groupEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupEnd(@NotNull KLQParser.GroupEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(@NotNull KLQParser.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KLQParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(@NotNull KLQParser.QuestionTypeContext ctx);
}