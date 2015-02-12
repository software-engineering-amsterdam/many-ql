// Generated from TaZQL.g4 by ANTLR 4.4
package com.antlr4.zarina.tazql;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TaZQLParser}.
 */
public interface TaZQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(@NotNull TaZQLParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(@NotNull TaZQLParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull TaZQLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull TaZQLParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#computedQuestion}.
	 * @param ctx the parse tree
	 */
	void enterComputedQuestion(@NotNull TaZQLParser.ComputedQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#computedQuestion}.
	 * @param ctx the parse tree
	 */
	void exitComputedQuestion(@NotNull TaZQLParser.ComputedQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqNot}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqNot(@NotNull TaZQLParser.EqNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqNot}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqNot(@NotNull TaZQLParser.EqNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifelseStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifelseStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equation}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquation(@NotNull TaZQLParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equation}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquation(@NotNull TaZQLParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(@NotNull TaZQLParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(@NotNull TaZQLParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull TaZQLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull TaZQLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#simpleQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#simpleQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull TaZQLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull TaZQLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code calcQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterCalcQuestion(@NotNull TaZQLParser.CalcQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calcQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitCalcQuestion(@NotNull TaZQLParser.CalcQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterBasicQuestion(@NotNull TaZQLParser.BasicQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitBasicQuestion(@NotNull TaZQLParser.BasicQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull TaZQLParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull TaZQLParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(@NotNull TaZQLParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(@NotNull TaZQLParser.MultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull TaZQLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull TaZQLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#formSection}.
	 * @param ctx the parse tree
	 */
	void enterFormSection(@NotNull TaZQLParser.FormSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#formSection}.
	 * @param ctx the parse tree
	 */
	void exitFormSection(@NotNull TaZQLParser.FormSectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull TaZQLParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull TaZQLParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull TaZQLParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull TaZQLParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prio}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrio(@NotNull TaZQLParser.PrioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prio}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrio(@NotNull TaZQLParser.PrioContext ctx);
}