package org.uva.sea.ql.encoders.ui;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestion;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestionnaire;

public class AstTransformer {

	public RuntimeQuestionnaire transform(Questionnaire questionnaire) {
		List<Question> questions = questionnaire.getQuestions();

		List<RuntimeQuestion> uiQuestions = createUIQuestions(questions);
		String name = questionnaire.getName();
		RuntimeQuestionnaire uiQuestionnaire = new RuntimeQuestionnaire(uiQuestions, name);

		return uiQuestionnaire;
	}

	private List<RuntimeQuestion> createUIQuestions(List<Question> questions) {
		List<RuntimeQuestion> uiQuestions = new ArrayList<RuntimeQuestion>();
		for (Question question : questions) {
			uiQuestions.add(new RuntimeQuestion(question));
		}
		return uiQuestions;
	}
}
