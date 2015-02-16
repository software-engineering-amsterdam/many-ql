package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.QL2BaseListener;
import org.uva.sea.ql.encoders.QL2Parser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.QL2Parser.ConditionalContext;
import org.uva.sea.ql.encoders.QL2Parser.FormContext;
import org.uva.sea.ql.encoders.QL2Parser.QuestionContext;
import org.uva.sea.ql.encoders.model.Question;
import org.uva.sea.ql.encoders.model.Questionaire;

/**
 * Creates and fills a {@link Questionaire} based on the parser input.
 * 
 * @author Pim Tegelaar
 */
public class QuestionaireListener extends QL2BaseListener {

	private final Questionaire questionaire = new Questionaire();

	private String condition;

	@Override
	public void exitForm(FormContext ctx) {
		questionaire.setName(ctx.formName.getText());
	}

	@Override
	public void exitQuestion(QuestionContext ctx) {
		Question question = new Question();
		question.setName(ctx.questionName.getText());
		question.setType(ctx.type.getText());
		question.setCondition(condition);
		questionaire.addQuestion(question);
	}

	@Override
	public void exitConditional(ConditionalContext ctx) {
		this.condition = ctx.getText();
	}

	@Override
	public void exitConditionalBlock(ConditionalBlockContext ctx) {
		this.condition = null;
	}

	public Questionaire getQuestionaire() {
		return questionaire;
	}
}
