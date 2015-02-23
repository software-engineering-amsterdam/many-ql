// Generated from QLbk.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLbkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLbkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLbkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull QLbkParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLbkParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull QLbkParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#questionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionName(@NotNull QLbkParser.QuestionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(@NotNull QLbkParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#builtinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinType(@NotNull QLbkParser.BuiltinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull QLbkParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(@NotNull QLbkParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull QLbkParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#questionLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(@NotNull QLbkParser.QuestionLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull QLbkParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLbkParser#userType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserType(@NotNull QLbkParser.UserTypeContext ctx);
}