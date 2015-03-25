// Generated from QL.g4 by ANTLR 4.5

	package uva.ql.parser;

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
	 * Visit a parse tree produced by the {@code SimpleQuestion}
	 * labeled alternative in {@link QLParser#quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleQuestion(QLParser.SimpleQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComputedQuestion}
	 * labeled alternative in {@link QLParser#quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedQuestion(QLParser.ComputedQuestionContext ctx);
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
	 * Visit a parse tree produced by {@link QLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(QLParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessEqualGreaterEqual}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqualGreaterEqual(QLParser.LessEqualGreaterEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(QLParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(QLParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(QLParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogOr}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogOr(QLParser.LogOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(QLParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exponentiation}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentiation(QLParser.ExponentiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualNot}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualNot(QLParser.EqualNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogAnd}
	 * labeled alternative in {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogAnd(QLParser.LogAndContext ctx);
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
	 * Visit a parse tree produced by the {@code BooleanPrimitive}
	 * labeled alternative in {@link QLParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanPrimitive(QLParser.BooleanPrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoneyPrimitive}
	 * labeled alternative in {@link QLParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoneyPrimitive(QLParser.MoneyPrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringPrimitive}
	 * labeled alternative in {@link QLParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPrimitive(QLParser.StringPrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntPrimitive}
	 * labeled alternative in {@link QLParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntPrimitive(QLParser.IntPrimitiveContext ctx);
}