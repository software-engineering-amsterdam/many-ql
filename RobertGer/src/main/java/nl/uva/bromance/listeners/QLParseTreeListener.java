package nl.uva.bromance.listeners;

import nl.uva.bromance.parsers.QLBaseListener;
import nl.uva.bromance.parsers.QLParser;
import nl.uva.bromance.questionnaire.ranges.Between;
import nl.uva.bromance.questionnaire.ranges.BiggerThan;
import nl.uva.bromance.questionnaire.ranges.Range;
import nl.uva.bromance.questionnaire.ranges.SmallerThan;

public class QLParseTreeListener extends QLBaseListener {

    private String questionnaireName;
    private String formName;
    private String questionType;
    private String questionText;
    private Range range;


    public void enterQuestionnaire(QLParser.QuestionnaireContext qtx) {
        this.questionnaireName = qtx.name.getText();
    }

    public void enterForm(QLParser.FormContext ftx) {
        this.formName = ftx.name.getText();
    }

    public void enterQuestion(QLParser.QuestionContext qtx) {
        this.questionType = null;
        this.questionText = null;
        this.range = null;
    }

    public void exitQuestion(QLParser.QuestionContext qtx) {
        System.out.println("Question : " + this.questionText + "\nhas type : " + this.questionType);
        if (range != null) {
            System.out.println("has range: " + range.toString());
        }
        // Empty line for debugging purposes
        System.out.println("");

    }

    public void enterQuestionText(QLParser.QuestionTextContext ctx) {
        this.questionText = ctx.text.getText();
    }

    public void enterQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx) {
        this.questionType = ctx.type.getText();
    }

    public void enterQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {

    }

    public void exitQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {
        this.range = new Between(Double.parseDouble(ctx.lower.getText()), Double.parseDouble(ctx.higher.getText()));
    }

    public void exitQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {
        this.range = new BiggerThan(Double.parseDouble(ctx.num.getText()));
    }

    public void exitQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {
        this.range = new SmallerThan(Double.parseDouble(ctx.num.getText()));
    }

}
