// Generated from /Users/lukaszharezlak/Projects/uva_software_construction/many-ql/Fugazi/src/org/fugazi/grammar/QL.g4 by ANTLR 4.5
package org.fugazi.parser;
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
	T visitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull QLParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(@NotNull QLParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionDecl(@NotNull QLParser.QuestionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull QLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#logical_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expression(@NotNull QLParser.Logical_expressionContext ctx);
}