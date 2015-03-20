// Generated from QLGrammar.g4 by ANTLR 4.5
package uva.sc.ql.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLGrammarParser}.
 */
public interface QLGrammarListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link QLGrammarParser#form}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForm(QLGrammarParser.FormContext ctx);

    /**
     * Exit a parse tree produced by {@link QLGrammarParser#form}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForm(QLGrammarParser.FormContext ctx);

    /**
     * Enter a parse tree produced by {@link QLGrammarParser#stat}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterStat(QLGrammarParser.StatContext ctx);

    /**
     * Exit a parse tree produced by {@link QLGrammarParser#stat}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitStat(QLGrammarParser.StatContext ctx);

    /**
     * Enter a parse tree produced by {@link QLGrammarParser#question}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQuestion(QLGrammarParser.QuestionContext ctx);

    /**
     * Exit a parse tree produced by {@link QLGrammarParser#question}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQuestion(QLGrammarParser.QuestionContext ctx);

    /**
     * Enter a parse tree produced by the {@code typeBoolean} labeled
     * alternative in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTypeBoolean(QLGrammarParser.TypeBooleanContext ctx);

    /**
     * Exit a parse tree produced by the {@code typeBoolean} labeled alternative
     * in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTypeBoolean(QLGrammarParser.TypeBooleanContext ctx);

    /**
     * Enter a parse tree produced by the {@code typeNumber} labeled alternative
     * in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTypeNumber(QLGrammarParser.TypeNumberContext ctx);

    /**
     * Exit a parse tree produced by the {@code typeNumber} labeled alternative
     * in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTypeNumber(QLGrammarParser.TypeNumberContext ctx);

    /**
     * Enter a parse tree produced by the {@code typeString} labeled alternative
     * in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTypeString(QLGrammarParser.TypeStringContext ctx);

    /**
     * Exit a parse tree produced by the {@code typeString} labeled alternative
     * in {@link QLGrammarParser#type}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTypeString(QLGrammarParser.TypeStringContext ctx);

    /**
     * Enter a parse tree produced by {@link QLGrammarParser#if_stat}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterIf_stat(QLGrammarParser.If_statContext ctx);

    /**
     * Exit a parse tree produced by {@link QLGrammarParser#if_stat}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitIf_stat(QLGrammarParser.If_statContext ctx);

    /**
     * Enter a parse tree produced by the {@code not} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterNot(QLGrammarParser.NotContext ctx);

    /**
     * Exit a parse tree produced by the {@code not} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitNot(QLGrammarParser.NotContext ctx);

    /**
     * Enter a parse tree produced by the {@code or} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterOr(QLGrammarParser.OrContext ctx);

    /**
     * Exit a parse tree produced by the {@code or} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitOr(QLGrammarParser.OrContext ctx);

    /**
     * Enter a parse tree produced by the {@code and} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAnd(QLGrammarParser.AndContext ctx);

    /**
     * Exit a parse tree produced by the {@code and} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAnd(QLGrammarParser.AndContext ctx);

    /**
     * Enter a parse tree produced by the {@code unaryMinus} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterUnaryMinus(QLGrammarParser.UnaryMinusContext ctx);

    /**
     * Exit a parse tree produced by the {@code unaryMinus} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitUnaryMinus(QLGrammarParser.UnaryMinusContext ctx);

    /**
     * Enter a parse tree produced by the {@code relational} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRelational(QLGrammarParser.RelationalContext ctx);

    /**
     * Exit a parse tree produced by the {@code relational} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRelational(QLGrammarParser.RelationalContext ctx);

    /**
     * Enter a parse tree produced by the {@code multiplication} labeled
     * alternative in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMultiplication(QLGrammarParser.MultiplicationContext ctx);

    /**
     * Exit a parse tree produced by the {@code multiplication} labeled
     * alternative in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMultiplication(QLGrammarParser.MultiplicationContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomium} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAtomium(QLGrammarParser.AtomiumContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomium} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAtomium(QLGrammarParser.AtomiumContext ctx);

    /**
     * Enter a parse tree produced by the {@code equality} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterEquality(QLGrammarParser.EqualityContext ctx);

    /**
     * Exit a parse tree produced by the {@code equality} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitEquality(QLGrammarParser.EqualityContext ctx);

    /**
     * Enter a parse tree produced by the {@code additive} labeled alternative
     * in {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAdditive(QLGrammarParser.AdditiveContext ctx);

    /**
     * Exit a parse tree produced by the {@code additive} labeled alternative in
     * {@link QLGrammarParser#expr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAdditive(QLGrammarParser.AdditiveContext ctx);

    /**
     * Enter a parse tree produced by the {@code parenthesis} labeled
     * alternative in {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterParenthesis(QLGrammarParser.ParenthesisContext ctx);

    /**
     * Exit a parse tree produced by the {@code parenthesis} labeled alternative
     * in {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitParenthesis(QLGrammarParser.ParenthesisContext ctx);

    /**
     * Enter a parse tree produced by the {@code number} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterNumber(QLGrammarParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by the {@code number} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitNumber(QLGrammarParser.NumberContext ctx);

    /**
     * Enter a parse tree produced by the {@code boolean} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterBoolean(QLGrammarParser.BooleanContext ctx);

    /**
     * Exit a parse tree produced by the {@code boolean} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitBoolean(QLGrammarParser.BooleanContext ctx);

    /**
     * Enter a parse tree produced by the {@code id} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterId(QLGrammarParser.IdContext ctx);

    /**
     * Exit a parse tree produced by the {@code id} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitId(QLGrammarParser.IdContext ctx);

    /**
     * Enter a parse tree produced by the {@code string} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterString(QLGrammarParser.StringContext ctx);

    /**
     * Exit a parse tree produced by the {@code string} labeled alternative in
     * {@link QLGrammarParser#atom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitString(QLGrammarParser.StringContext ctx);
}