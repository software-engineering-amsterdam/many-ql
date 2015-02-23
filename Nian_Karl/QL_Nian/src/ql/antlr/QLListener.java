// Generated from QL.g4 by ANTLR 4.4
package ql.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ExprGreater}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGreater(@NotNull QLParser.ExprGreaterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprGreater}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGreater(@NotNull QLParser.ExprGreaterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull QLParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull QLParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultiply}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiply(@NotNull QLParser.ExprMultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultiply}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiply(@NotNull QLParser.ExprMultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLess}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLess(@NotNull QLParser.ExprLessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLess}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLess(@NotNull QLParser.ExprLessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprGreaterEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGreaterEqual(@NotNull QLParser.ExprGreaterEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprGreaterEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGreaterEqual(@NotNull QLParser.ExprGreaterEqualContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprParentheses(@NotNull QLParser.ExprParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprParentheses(@NotNull QLParser.ExprParenthesesContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprEqual(@NotNull QLParser.ExprEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprEqual(@NotNull QLParser.ExprEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Date}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDate(@NotNull QLParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Date}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDate(@NotNull QLParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLessEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLessEqual(@NotNull QLParser.ExprLessEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLessEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLessEqual(@NotNull QLParser.ExprLessEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDevide}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprDevide(@NotNull QLParser.ExprDevideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDevide}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprDevide(@NotNull QLParser.ExprDevideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dec}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDec(@NotNull QLParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dec}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDec(@NotNull QLParser.DecContext ctx);
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
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull QLParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull QLParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(@NotNull QLParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(@NotNull QLParser.ExprLiteralContext ctx);
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
	 * Enter a parse tree produced by the {@code Str}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStr(@NotNull QLParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStr(@NotNull QLParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMinus(@NotNull QLParser.ExprMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMinus(@NotNull QLParser.ExprMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull QLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull QLParser.IfStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(@NotNull QLParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(@NotNull QLParser.ExprAssignContext ctx);
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
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull QLParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull QLParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPlus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPlus(@NotNull QLParser.ExprPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPlus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPlus(@NotNull QLParser.ExprPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(@NotNull QLParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(@NotNull QLParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(@NotNull QLParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(@NotNull QLParser.ExprAndContext ctx);
}