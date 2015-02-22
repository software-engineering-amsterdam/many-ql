// Generated from Grammar.g4 by ANTLR 4.4
 package uva.sc.parser; 
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull GrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull GrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull GrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull GrammarParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull GrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull GrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull GrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull GrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomium}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomium(@NotNull GrammarParser.AtomiumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomium}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomium(@NotNull GrammarParser.AtomiumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(@NotNull GrammarParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(@NotNull GrammarParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additive}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(@NotNull GrammarParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additive}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(@NotNull GrammarParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull GrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull GrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull GrammarParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull GrammarParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull GrammarParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull GrammarParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull GrammarParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull GrammarParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull GrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull GrammarParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(@NotNull GrammarParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(@NotNull GrammarParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relational}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational(@NotNull GrammarParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relational}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational(@NotNull GrammarParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(@NotNull GrammarParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(@NotNull GrammarParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPower(@NotNull GrammarParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPower(@NotNull GrammarParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(@NotNull GrammarParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(@NotNull GrammarParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull GrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull GrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equality}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquality(@NotNull GrammarParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquality(@NotNull GrammarParser.EqualityContext ctx);
}