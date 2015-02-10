// Generated from TaZQL.g4 by ANTLR 4.4
package com.antlr4.zarina.tazql;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TaZQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TaZQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull TaZQLParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#computedQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedQuestion(@NotNull TaZQLParser.ComputedQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqNot}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNot(@NotNull TaZQLParser.EqNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelseStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equation}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(@NotNull TaZQLParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(@NotNull TaZQLParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull TaZQLParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull TaZQLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#simpleQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull TaZQLParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calcQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcQuestion(@NotNull TaZQLParser.CalcQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicQuestion(@NotNull TaZQLParser.BasicQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(@NotNull TaZQLParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDiv(@NotNull TaZQLParser.MultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull TaZQLParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#formSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormSection(@NotNull TaZQLParser.FormSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull TaZQLParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code text}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull TaZQLParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prio}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrio(@NotNull TaZQLParser.PrioContext ctx);
}