// Generated from QL.g4 by ANTLR 4.5

	package uva.ql.parser;
	import uva.ql.ast.expressions.*;
	import uva.ql.ast.expressions.literals.*;
	import uva.ql.ast.expressions.math.*;
	import uva.ql.ast.expressions.logic.*;
	import java.util.*;

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
	 * Visit a parse tree produced by {@link QLParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(QLParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuest(QLParser.QuestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxExpression}
	 * labeled alternative in {@link QLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxExpression(QLParser.CtxExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxQuestion}
	 * labeled alternative in {@link QLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxQuestion(QLParser.CtxQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxIfStatement}
	 * labeled alternative in {@link QLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxIfStatement(QLParser.CtxIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxAssign}
	 * labeled alternative in {@link QLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxAssign(QLParser.CtxAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link QLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(QLParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStr}
	 * labeled alternative in {@link QLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStr(QLParser.AssignStrContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(QLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(QLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxBooleanLiteral}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxBooleanLiteral(QLParser.CtxBooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxIntLiteral}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxIntLiteral(QLParser.CtxIntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxMoneyLiteral}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxMoneyLiteral(QLParser.CtxMoneyLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtxIdentifier}
	 * labeled alternative in {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtxIdentifier(QLParser.CtxIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(QLParser.PrimitiveTypeContext ctx);
}