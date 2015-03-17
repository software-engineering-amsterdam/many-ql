// Generated from QLGrammar.g4 by ANTLR 4.5
package uva.sc.ql.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLGrammarParser}.
 *
 * @param <T>
 *            The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface QLGrammarVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link QLGrammarParser#form}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitForm(QLGrammarParser.FormContext ctx);

    /**
     * Visit a parse tree produced by {@link QLGrammarParser#stat}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitStat(QLGrammarParser.StatContext ctx);

    /**
     * Visit a parse tree produced by {@link QLGrammarParser#question}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitQuestion(QLGrammarParser.QuestionContext ctx);

    /**
     * Visit a parse tree produced by the {@code typeBoolean} labeled
     * alternative in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitTypeBoolean(QLGrammarParser.TypeBooleanContext ctx);

    /**
     * Visit a parse tree produced by the {@code typeNumber} labeled alternative
     * in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitTypeNumber(QLGrammarParser.TypeNumberContext ctx);

    /**
     * Visit a parse tree produced by the {@code typeString} labeled alternative
     * in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitTypeString(QLGrammarParser.TypeStringContext ctx);

    /**
     * Visit a parse tree produced by {@link QLGrammarParser#if_stat}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitIf_stat(QLGrammarParser.If_statContext ctx);

    /**
     * Visit a parse tree produced by the {@code not} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitNot(QLGrammarParser.NotContext ctx);

    /**
     * Visit a parse tree produced by the {@code or} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitOr(QLGrammarParser.OrContext ctx);

    /**
     * Visit a parse tree produced by the {@code and} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitAnd(QLGrammarParser.AndContext ctx);

    /**
     * Visit a parse tree produced by the {@code unaryMinus} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitUnaryMinus(QLGrammarParser.UnaryMinusContext ctx);

    /**
     * Visit a parse tree produced by the {@code relational} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitRelational(QLGrammarParser.RelationalContext ctx);

    /**
     * Visit a parse tree produced by the {@code multiplication} labeled
     * alternative in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitMultiplication(QLGrammarParser.MultiplicationContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomium} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitAtomium(QLGrammarParser.AtomiumContext ctx);

    /**
     * Visit a parse tree produced by the {@code equality} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitEquality(QLGrammarParser.EqualityContext ctx);

    /**
     * Visit a parse tree produced by the {@code additive} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitAdditive(QLGrammarParser.AdditiveContext ctx);

    /**
     * Visit a parse tree produced by the {@code parenthesis} labeled
     * alternative in {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitParenthesis(QLGrammarParser.ParenthesisContext ctx);

    /**
     * Visit a parse tree produced by the {@code number} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitNumber(QLGrammarParser.NumberContext ctx);

    /**
     * Visit a parse tree produced by the {@code boolean} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitBoolean(QLGrammarParser.BooleanContext ctx);

    /**
     * Visit a parse tree produced by the {@code id} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitId(QLGrammarParser.IdContext ctx);

    /**
     * Visit a parse tree produced by the {@code string} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     * @return the visitor result
     */
    T visitString(QLGrammarParser.StringContext ctx);
}