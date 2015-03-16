package nl.uva.sc.encoders.qlruntime.service;

import java.util.List;

import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.qlruntime.runtime.model.RuntimeQuestion;

public class QuestionByName {

	public Question getQuestion(String name, List<Question> questions) {
		for (Question question : questions) {
			if (questionHasName(question, name)) {
				return question;
			}
		}
		return null;
	}

	public RuntimeQuestion getRuntimeQuestion(String name, List<RuntimeQuestion> runtimeQuestions) {
		for (RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			Question question = runtimeQuestion.getQuestion();
			if (questionHasName(question, name)) {
				return runtimeQuestion;
			}
		}
		return null;
	}

	private boolean questionHasName(Question question, String name) {
		return name.equals(question.getName());
	}
}
