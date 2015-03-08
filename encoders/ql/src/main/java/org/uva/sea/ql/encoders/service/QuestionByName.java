package org.uva.sea.ql.encoders.service;

import java.util.List;

import org.uva.sea.ql.encoders.ast.Question;

public class QuestionByName {

	public Question getQuestion(String name, List<Question> questions) {
		for (Question question : questions) {
			String questionName = question.getName();
			if (name.equals(questionName)) {
				return question;
			}
		}
		return null;
	}
}
