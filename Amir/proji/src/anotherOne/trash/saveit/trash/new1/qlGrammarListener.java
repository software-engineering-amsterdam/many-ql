package anotherOne.grammar.saveit.trash.new1;
// Generated from qlGrammar.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link qlGrammarParser}.
 */
public interface qlGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#completeQuestion}.
	 * @param ctx the parse tree
	 */
	void enterCompleteQuestion(@NotNull qlGrammarParser.CompleteQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#completeQuestion}.
	 * @param ctx the parse tree
	 */
	void exitCompleteQuestion(@NotNull qlGrammarParser.CompleteQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#parens}.
	 * @param ctx the parse tree
	 */
	void enterParens(@NotNull qlGrammarParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#parens}.
	 * @param ctx the parse tree
	 */
	void exitParens(@NotNull qlGrammarParser.ParensContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(@NotNull qlGrammarParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(@NotNull qlGrammarParser.CompareContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull qlGrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull qlGrammarParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull qlGrammarParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull qlGrammarParser.BoolContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#MulDiv}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(@NotNull qlGrammarParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#MulDiv}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(@NotNull qlGrammarParser.MulDivContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#AddSub}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(@NotNull qlGrammarParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#AddSub}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(@NotNull qlGrammarParser.AddSubContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#completeComputedQuestion}.
	 * @param ctx the parse tree
	 */
	void enterCompleteComputedQuestion(@NotNull qlGrammarParser.CompleteComputedQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#completeComputedQuestion}.
	 * @param ctx the parse tree
	 */
	void exitCompleteComputedQuestion(@NotNull qlGrammarParser.CompleteComputedQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#strType}.
	 * @param ctx the parse tree
	 */
	void enterStrType(@NotNull qlGrammarParser.StrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#strType}.
	 * @param ctx the parse tree
	 */
	void exitStrType(@NotNull qlGrammarParser.StrTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#intType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull qlGrammarParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#intType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull qlGrammarParser.IntTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#box}.
	 * @param ctx the parse tree
	 */
	void enterBox(@NotNull qlGrammarParser.BoxContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#box}.
	 * @param ctx the parse tree
	 */
	void exitBox(@NotNull qlGrammarParser.BoxContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#boolType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull qlGrammarParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#boolType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull qlGrammarParser.BoolTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull qlGrammarParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull qlGrammarParser.IntContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull qlGrammarParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull qlGrammarParser.NotContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull qlGrammarParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull qlGrammarParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull qlGrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull qlGrammarParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link qlGrammarParser#conditionalQuestion}.
	 * @param ctx the parse tree
	 */
	void enterConditionalQuestion(@NotNull qlGrammarParser.ConditionalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link qlGrammarParser#conditionalQuestion}.
	 * @param ctx the parse tree
	 */
	void exitConditionalQuestion(@NotNull qlGrammarParser.ConditionalQuestionContext ctx);
}