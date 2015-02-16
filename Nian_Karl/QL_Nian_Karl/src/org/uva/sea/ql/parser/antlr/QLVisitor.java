// Generated from QL.g4 by ANTLR 4.4
package org.uva.sea.ql.parser.antlr;

	import org.uva.sea.ql.model.expression.*;
	import org.uva.sea.ql.model.expression.commonexpression.*;
	import org.uva.sea.ql.model.expression.booleanexpression.*;
	import org.uva.sea.ql.model.expression.mathexpression.*;
	import org.uva.sea.ql.model.literal.*;
	import org.uva.sea.ql.model.value.*;

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
	 * Visit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull QLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionName(@NotNull QLParser.QuestionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull QLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(@NotNull QLParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(@NotNull QLParser.QuestionLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull QLParser.LiteralContext ctx);
}