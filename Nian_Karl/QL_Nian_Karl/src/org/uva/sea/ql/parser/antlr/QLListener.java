// Generated from QL.g4 by ANTLR 4.5
package org.uva.sea.ql.parser.antlr;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(QLParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(QLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(QLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(QLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(QLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(QLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(QLParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(QLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(QLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(QLParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(QLParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(QLParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(QLParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(QLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(QLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(QLParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(QLParser.BoolContext ctx);
}