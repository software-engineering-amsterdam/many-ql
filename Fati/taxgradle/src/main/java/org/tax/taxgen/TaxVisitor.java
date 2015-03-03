// Generated from Tax.g4 by ANTLR 4.5

package org.tax.taxgen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TaxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TaxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TaxParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(TaxParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(TaxParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#questionlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionlist(TaxParser.QuestionlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#bracketedquestionlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketedquestionlist(TaxParser.BracketedquestionlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#ifquestionlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfquestionlist(TaxParser.IfquestionlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(TaxParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#questionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionStatement(TaxParser.QuestionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TaxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(TaxParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeration(TaxParser.EnumerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#enumItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumItem(TaxParser.EnumItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TaxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(TaxParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(TaxParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaxParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(TaxParser.VariableContext ctx);
}