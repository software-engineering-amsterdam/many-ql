// Generated from Grammar.g4 by ANTLR 4.5
 package uva.sc.parser; 
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(GrammarParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(GrammarParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(GrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(GrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(GrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(GrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(GrammarParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(GrammarParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(GrammarParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(GrammarParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(GrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(GrammarParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(GrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(GrammarParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(GrammarParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(GrammarParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relational}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational(GrammarParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relational}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational(GrammarParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPower(GrammarParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPower(GrammarParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(GrammarParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(GrammarParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomium}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomium(GrammarParser.AtomiumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomium}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomium(GrammarParser.AtomiumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equality}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquality(GrammarParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquality(GrammarParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additive}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(GrammarParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additive}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(GrammarParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(GrammarParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(GrammarParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumber(GrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumber(GrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(GrammarParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(GrammarParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterId(GrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitId(GrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterString(GrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitString(GrammarParser.StringContext ctx);
}