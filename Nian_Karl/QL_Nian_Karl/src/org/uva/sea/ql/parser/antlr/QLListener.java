// Generated from QL.g4 by ANTLR 4.4
package org.uva.sea.ql.parser.antlr;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull QLParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull QLParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(@NotNull QLParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(@NotNull QLParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMult(@NotNull QLParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMult(@NotNull QLParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(@NotNull QLParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(@NotNull QLParser.MinusContext ctx);
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
	 * Enter a parse tree produced by the {@code greaterEqualCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqualCond(@NotNull QLParser.GreaterEqualCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterEqualCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqualCond(@NotNull QLParser.GreaterEqualCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualCond(@NotNull QLParser.EqualCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualCond(@NotNull QLParser.EqualCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDiv(@NotNull QLParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDiv(@NotNull QLParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessEqualCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessEqualCond(@NotNull QLParser.LessEqualCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessEqualCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessEqualCond(@NotNull QLParser.LessEqualCondContext ctx);
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
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull QLParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull QLParser.OrExprContext ctx);
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
	 * Enter a parse tree produced by the {@code greaterCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterCond(@NotNull QLParser.GreaterCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterCond(@NotNull QLParser.GreaterCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessCond(@NotNull QLParser.LessCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessCond}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessCond(@NotNull QLParser.LessCondContext ctx);
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
	 * Enter a parse tree produced by the {@code normalLit}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNormalLit(@NotNull QLParser.NormalLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalLit}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNormalLit(@NotNull QLParser.NormalLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(@NotNull QLParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(@NotNull QLParser.ParenthesisContext ctx);
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
	 * Enter a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull QLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull QLParser.LiteralContext ctx);
}