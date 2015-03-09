// Generated from Tax.g4 by ANTLR 4.5

package org.tax.taxgen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TaxParser}.
 */
public interface TaxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TaxParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(TaxParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(TaxParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(TaxParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(TaxParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#questionlist}.
	 * @param ctx the parse tree
	 */
	void enterQuestionlist(TaxParser.QuestionlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#questionlist}.
	 * @param ctx the parse tree
	 */
	void exitQuestionlist(TaxParser.QuestionlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#bracketedquestionlist}.
	 * @param ctx the parse tree
	 */
	void enterBracketedquestionlist(TaxParser.BracketedquestionlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#bracketedquestionlist}.
	 * @param ctx the parse tree
	 */
	void exitBracketedquestionlist(TaxParser.BracketedquestionlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#ifquestionlist}.
	 * @param ctx the parse tree
	 */
	void enterIfquestionlist(TaxParser.IfquestionlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#ifquestionlist}.
	 * @param ctx the parse tree
	 */
	void exitIfquestionlist(TaxParser.IfquestionlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(TaxParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(TaxParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#questionStatement}.
	 * @param ctx the parse tree
	 */
	void enterQuestionStatement(TaxParser.QuestionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#questionStatement}.
	 * @param ctx the parse tree
	 */
	void exitQuestionStatement(TaxParser.QuestionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TaxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TaxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(TaxParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(TaxParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration(TaxParser.EnumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration(TaxParser.EnumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#enumItem}.
	 * @param ctx the parse tree
	 */
	void enterEnumItem(TaxParser.EnumItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#enumItem}.
	 * @param ctx the parse tree
	 */
	void exitEnumItem(TaxParser.EnumItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TaxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TaxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(TaxParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(TaxParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(TaxParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(TaxParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaxParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(TaxParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaxParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(TaxParser.VariableContext ctx);
}