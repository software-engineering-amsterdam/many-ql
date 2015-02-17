// Generated from /home/juriaan/Development/IdeaProjects/many-ql/kennedy-langlotz/src/KLQ.g4 by ANTLR 4.5
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KLQParser}.
 */
public interface KLQListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KLQParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(@NotNull KLQParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(@NotNull KLQParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull KLQParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull KLQParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#condQuestion}.
	 * @param ctx the parse tree
	 */
	void enterCondQuestion(@NotNull KLQParser.CondQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#condQuestion}.
	 * @param ctx the parse tree
	 */
	void exitCondQuestion(@NotNull KLQParser.CondQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#uncondQuestion}.
	 * @param ctx the parse tree
	 */
	void enterUncondQuestion(@NotNull KLQParser.UncondQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#uncondQuestion}.
	 * @param ctx the parse tree
	 */
	void exitUncondQuestion(@NotNull KLQParser.UncondQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(@NotNull KLQParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(@NotNull KLQParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull KLQParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull KLQParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull KLQParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull KLQParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(@NotNull KLQParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(@NotNull KLQParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(@NotNull KLQParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(@NotNull KLQParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(@NotNull KLQParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(@NotNull KLQParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparators}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparators(@NotNull KLQParser.ComparatorsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparators}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparators(@NotNull KLQParser.ComparatorsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull KLQParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull KLQParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull KLQParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull KLQParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull KLQParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull KLQParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Date}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDate(@NotNull KLQParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Date}
	 * labeled alternative in {@link KLQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDate(@NotNull KLQParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link KLQParser#answerSet}.
	 * @param ctx the parse tree
	 */
	void enterAnswerSet(@NotNull KLQParser.AnswerSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KLQParser#answerSet}.
	 * @param ctx the parse tree
	 */
	void exitAnswerSet(@NotNull KLQParser.AnswerSetContext ctx);
}