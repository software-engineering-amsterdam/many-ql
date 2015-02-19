// Generated from QL.g4 by ANTLR 4.5
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
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(QLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(QLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QLParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionName(QLParser.QuestionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(QLParser.QuestionLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(QLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprGreater}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGreater(QLParser.ExprGreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPlus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPlus(QLParser.ExprPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentheses(QLParser.ExprParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLess}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLess(QLParser.ExprLessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLessEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLessEqual(QLParser.ExprLessEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(QLParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDevide}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDevide(QLParser.ExprDevideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMinus(QLParser.ExprMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(QLParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprGreaterEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGreaterEqual(QLParser.ExprGreaterEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(QLParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(QLParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultiply}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiply(QLParser.ExprMultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEqual(QLParser.ExprEqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(QLParser.LiteralContext ctx);
}