package org.uva.sea.ql.encoders.validation;

import org.uva.sea.ql.encoders.ast.Question;

public class Validation {

	private final ValidationType type;

	private final Question question;

	public Validation(ValidationType type, Question question) {
		this.type = type;
		this.question = question;
	}

	public Question getQuestion() {
		return question;
	}

	public ValidationType getType() {
		return type;
	}

}
