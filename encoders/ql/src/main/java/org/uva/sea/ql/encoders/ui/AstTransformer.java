package org.uva.sea.ql.encoders.ui;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.model.UIQuestion;
import org.uva.sea.ql.encoders.model.UIQuestionnaire;

public class AstTransformer {

	public UIQuestionnaire transform(Questionnaire questionnaire) {
		List<Question> questions = questionnaire.getQuestions();

		List<UIQuestion> uiQuestions = createUIQuestions(questions);
		String name = questionnaire.getName();
		UIQuestionnaire uiQuestionnaire = new UIQuestionnaire(uiQuestions, name);

		return uiQuestionnaire;
	}

	private List<UIQuestion> createUIQuestions(List<Question> questions) {
		List<UIQuestion> uiQuestions = new ArrayList<UIQuestion>();
		for (Question question : questions) {
			uiQuestions.add(new UIQuestion(question));
		}
		return uiQuestions;
	}
}
