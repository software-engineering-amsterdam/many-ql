// Generated from Expr.g4 by ANTLR 4.5

package org.tax.exprgen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#myexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyexpr(ExprParser.MyexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DECIMALLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDECIMALLiteral(ExprParser.DECIMALLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTLiteral(ExprParser.INTLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarLiteral(ExprParser.VarLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOLLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOLLiteral(ExprParser.BOOLLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LITExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLITExpr(ExprParser.LITExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ANDExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitANDExpr(ExprParser.ANDExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDSUBExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDSUBExpr(ExprParser.ADDSUBExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PARExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPARExpr(ExprParser.PARExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQUALExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQUALExpr(ExprParser.EQUALExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BANGExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBANGExpr(ExprParser.BANGExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ORExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORExpr(ExprParser.ORExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COMPExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOMPExpr(ExprParser.COMPExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULDIVExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULDIVExpr(ExprParser.MULDIVExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ExprParser.VariableContext ctx);
}