// Generated from QL.g4 by ANTLR 4.4
package org.uva.sea.ql.parser.antlr;

	import org.uva.sea.ql.model.expression.*;
	import org.uva.sea.ql.model.expression.commonexpression.*;
	import org.uva.sea.ql.model.expression.booleanexpression.*;
	import org.uva.sea.ql.model.expression.mathexpression.*;
	import org.uva.sea.ql.model.literal.*;
	import org.uva.sea.ql.model.value.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull QLParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull QLParser.AndExprContext ctx);
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
	 * Enter a parse tree produced by {@link QLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(@NotNull QLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(@NotNull QLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull QLParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull QLParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull QLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull QLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(@NotNull QLParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(@NotNull QLParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(@NotNull QLParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(@NotNull QLParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(@NotNull QLParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(@NotNull QLParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull QLParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull QLParser.OrExprContext ctx);
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
	 * Enter a parse tree produced by {@link QLParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(@NotNull QLParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(@NotNull QLParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull QLParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull QLParser.BoolContext ctx);
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
	 * Enter a parse tree produced by {@link QLParser#unExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnExpr(@NotNull QLParser.UnExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#unExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnExpr(@NotNull QLParser.UnExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull QLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull QLParser.IdentifierContext ctx);
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