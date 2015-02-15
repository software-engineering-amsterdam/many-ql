package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.QL2BaseListener;
import org.uva.sea.ql.encoders.QL2Parser.FormContext;
import org.uva.sea.ql.encoders.QL2Parser.QuestionRuleContext;
import org.uva.sea.ql.encoders.model.Question;
import org.uva.sea.ql.encoders.model.Questionaire;

/**
 * Creates and fills a {@link Questionaire} based on the parser input.
 * 
 * @author Pim Tegelaar
 */
public class QuestionaireListener extends QL2BaseListener {

	private final Questionaire questionaire = new Questionaire();

	@Override
	public void exitForm(FormContext ctx) {
		questionaire.setName(ctx.formName.getText());
	}

	@Override
	public void exitQuestionRule(QuestionRuleContext ctx) {
		Question question = new Question();
		question.setName(ctx.questionName.getText());
		questionaire.addQuestion(question);
	}

	public Questionaire getQuestionaire() {
		return questionaire;
	}
}
