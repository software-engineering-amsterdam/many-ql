package nl.uva.se.gui.widgets.questions;

import nl.uva.se.gui.validators.DecimalValidator;
import nl.uva.se.ql.ast.statement.Question;

public class DecimalQuestion {
	private final Question question;
	private final DecimalValidator validator;

	public DecimalQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new DecimalValidator();
	}

	public Question getQuestion() {
		return this.question;
	}

	public DecimalValidator getValidator() {
		return this.validator;
	}

}
