package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.EncodersQLBaseListener;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.model.Question;
import org.uva.sea.ql.encoders.model.Questionnaire;

/**
 * Creates and fills a {@link Questionnaire} based on the parser input.
 * 
 * @author Pim Tegelaar
 */
public class QuestionnaireListener extends EncodersQLBaseListener {

	private final Questionnaire questionnaire = new Questionnaire();

	private String condition;

	@Override
	public void exitQuestionnaire(QuestionnaireContext ctx) {
		questionnaire.setName(ctx.formName.getText());
	}

	@Override
	public void exitQuestion(QuestionContext ctx) {
		Question question = new Question();
		question.setName(ctx.questionName.getText());
		question.setType(ctx.type.getText());
		question.setCondition(condition);
		question.setQuestionText(ctx.questionString.getText());
		questionnaire.addQuestion(question);
	}

	@Override
	public void exitConditional(ConditionalContext ctx) {
		this.condition = ctx.getText();
	}

	@Override
	public void exitConditionalBlock(ConditionalBlockContext ctx) {
		this.condition = null;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
}
