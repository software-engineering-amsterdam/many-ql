// Generated from nl\u005Cuva\bromance\parsers\QL.g4 by ANTLR 4.5
package nl.uva.bromance.parsers;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(QLParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(QLParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionnaireBody}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaireBody(QLParser.QuestionnaireBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionnaireBody}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaireBody(QLParser.QuestionnaireBodyContext ctx);
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
	 * Enter a parse tree produced by {@link QLParser#formBody}.
	 * @param ctx the parse tree
	 */
	void enterFormBody(QLParser.FormBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#formBody}.
	 * @param ctx the parse tree
	 */
	void exitFormBody(QLParser.FormBodyContext ctx);
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
	 * Enter a parse tree produced by {@link QLParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void enterQuestionBody(QLParser.QuestionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void exitQuestionBody(QLParser.QuestionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionText}.
	 * @param ctx the parse tree
	 */
	void enterQuestionText(QLParser.QuestionTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionText}.
	 * @param ctx the parse tree
	 */
	void exitQuestionText(QLParser.QuestionTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionAnswer}.
	 * @param ctx the parse tree
	 */
	void enterQuestionAnswer(QLParser.QuestionAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionAnswer}.
	 * @param ctx the parse tree
	 */
	void exitQuestionAnswer(QLParser.QuestionAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionAnswerSimple}.
	 * @param ctx the parse tree
	 */
	void enterQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionAnswerSimple}.
	 * @param ctx the parse tree
	 */
	void exitQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionAnswerCustom}.
	 * @param ctx the parse tree
	 */
	void enterQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionAnswerCustom}.
	 * @param ctx the parse tree
	 */
	void exitQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionRange}.
	 * @param ctx the parse tree
	 */
	void enterQuestionRange(QLParser.QuestionRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionRange}.
	 * @param ctx the parse tree
	 */
	void exitQuestionRange(QLParser.QuestionRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionRangeFromTo}.
	 * @param ctx the parse tree
	 */
	void enterQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionRangeFromTo}.
	 * @param ctx the parse tree
	 */
	void exitQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionRangeBiggerThan}.
	 * @param ctx the parse tree
	 */
	void enterQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionRangeBiggerThan}.
	 * @param ctx the parse tree
	 */
	void exitQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionRangeSmallerThan}.
	 * @param ctx the parse tree
	 */
	void enterQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionRangeSmallerThan}.
	 * @param ctx the parse tree
	 */
	void exitQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterCalculation(QLParser.CalculationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitCalculation(QLParser.CalculationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#calculationBody}.
	 * @param ctx the parse tree
	 */
	void enterCalculationBody(QLParser.CalculationBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#calculationBody}.
	 * @param ctx the parse tree
	 */
	void exitCalculationBody(QLParser.CalculationBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#ifSequence}.
	 * @param ctx the parse tree
	 */
	void enterIfSequence(QLParser.IfSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifSequence}.
	 * @param ctx the parse tree
	 */
	void exitIfSequence(QLParser.IfSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(QLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(QLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(QLParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(QLParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(QLParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(QLParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#statementBody}.
	 * @param ctx the parse tree
	 */
	void enterStatementBody(QLParser.StatementBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statementBody}.
	 * @param ctx the parse tree
	 */
	void exitStatementBody(QLParser.StatementBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(QLParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(QLParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#labelBody}.
	 * @param ctx the parse tree
	 */
	void enterLabelBody(QLParser.LabelBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#labelBody}.
	 * @param ctx the parse tree
	 */
	void exitLabelBody(QLParser.LabelBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#labelText}.
	 * @param ctx the parse tree
	 */
	void enterLabelText(QLParser.LabelTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#labelText}.
	 * @param ctx the parse tree
	 */
	void exitLabelText(QLParser.LabelTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(QLParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(QLParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(QLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(QLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(QLParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(QLParser.IdContext ctx);
}