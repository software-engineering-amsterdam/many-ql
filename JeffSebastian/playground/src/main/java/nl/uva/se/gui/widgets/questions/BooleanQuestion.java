package nl.uva.se.gui.widgets.questions;

import nl.uva.se.gui.validators.BooleanValidator;
import nl.uva.se.ql.ast.statement.Question;
import javafx.scene.control.CheckBox;

public class BooleanQuestion extends CheckBox {

	private final Question question;
	private final BooleanValidator validator;

	public BooleanQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new BooleanValidator();
	}

	public Question getQuestion() {
		return this.question;
	}

	public BooleanValidator getValidator() {
		return this.validator;
	}
}
