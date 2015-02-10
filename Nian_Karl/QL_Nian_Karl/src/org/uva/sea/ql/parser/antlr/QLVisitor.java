// Generated from QL.g4 by ANTLR 4.5
package org.uva.sea.ql.parser.antlr;


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
	 * Visit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QLParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(QLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(QLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(QLParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(QLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(QLParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(QLParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(QLParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(QLParser.BoolContext ctx);
}