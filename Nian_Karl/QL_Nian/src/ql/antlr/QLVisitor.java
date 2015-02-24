// Generated from QL.g4 by ANTLR 4.4
package ql.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ExprGreater}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGreater(@NotNull QLParser.ExprGreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull QLParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultiply}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiply(@NotNull QLParser.ExprMultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLess}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLess(@NotNull QLParser.ExprLessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprGreaterEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGreaterEqual(@NotNull QLParser.ExprGreaterEqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull QLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentheses(@NotNull QLParser.ExprParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(@NotNull QLParser.QuestionLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEqual(@NotNull QLParser.ExprEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Date}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(@NotNull QLParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLessEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLessEqual(@NotNull QLParser.ExprLessEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDevide}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDevide(@NotNull QLParser.ExprDevideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dec}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(@NotNull QLParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(@NotNull QLParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull QLParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(@NotNull QLParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(@NotNull QLParser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMinus(@NotNull QLParser.ExprMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull QLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(@NotNull QLParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionName(@NotNull QLParser.QuestionNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull QLParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPlus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPlus(@NotNull QLParser.ExprPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(@NotNull QLParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(@NotNull QLParser.ExprAndContext ctx);
}