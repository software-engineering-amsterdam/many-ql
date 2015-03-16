package nl.uva.se.gui.widgets.questions;

import nl.uva.se.gui.validators.IntegerValidator;
import nl.uva.se.ql.ast.statement.Question;
import javafx.scene.control.TextField;

public class IntegerQuestion extends TextField {

	private final Question question;
	private final IntegerValidator validator;

	public IntegerQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new IntegerValidator();
	}

	public Question getQuestion() {
		return this.question;
	}

	public IntegerValidator getValidator() {
		return this.validator;
	}
}
