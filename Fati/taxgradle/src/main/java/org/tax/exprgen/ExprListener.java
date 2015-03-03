// Generated from Expr.g4 by ANTLR 4.5

package org.tax.exprgen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#myexpr}.
	 * @param ctx the parse tree
	 */
	void enterMyexpr(ExprParser.MyexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#myexpr}.
	 * @param ctx the parse tree
	 */
	void exitMyexpr(ExprParser.MyexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DECIMALLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDECIMALLiteral(ExprParser.DECIMALLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DECIMALLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDECIMALLiteral(ExprParser.DECIMALLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterINTLiteral(ExprParser.INTLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitINTLiteral(ExprParser.INTLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterVarLiteral(ExprParser.VarLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitVarLiteral(ExprParser.VarLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOLLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBOOLLiteral(ExprParser.BOOLLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOLLiteral}
	 * labeled alternative in {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBOOLLiteral(ExprParser.BOOLLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LITExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLITExpr(ExprParser.LITExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LITExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLITExpr(ExprParser.LITExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ANDExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterANDExpr(ExprParser.ANDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ANDExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitANDExpr(ExprParser.ANDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDSUBExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterADDSUBExpr(ExprParser.ADDSUBExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDSUBExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitADDSUBExpr(ExprParser.ADDSUBExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PARExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPARExpr(ExprParser.PARExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PARExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPARExpr(ExprParser.PARExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EQUALExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEQUALExpr(ExprParser.EQUALExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EQUALExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEQUALExpr(ExprParser.EQUALExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BANGExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBANGExpr(ExprParser.BANGExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BANGExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBANGExpr(ExprParser.BANGExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ORExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterORExpr(ExprParser.ORExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ORExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitORExpr(ExprParser.ORExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COMPExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCOMPExpr(ExprParser.COMPExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COMPExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCOMPExpr(ExprParser.COMPExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULDIVExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMULDIVExpr(ExprParser.MULDIVExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULDIVExpr}
	 * labeled alternative in {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMULDIVExpr(ExprParser.MULDIVExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ExprParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ExprParser.VariableContext ctx);
}