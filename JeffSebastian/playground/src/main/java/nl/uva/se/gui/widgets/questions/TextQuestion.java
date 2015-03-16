package nl.uva.se.gui.widgets.questions;

import nl.uva.se.gui.validators.TextValidator;
import nl.uva.se.ql.ast.statement.Question;
import javafx.scene.control.TextField;

public class TextQuestion extends TextField {

	private final Question question;
	private final TextValidator validator;

	public TextQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new TextValidator();
	}

	public Question getQuestion() {
		return this.question;
	}

	public TextValidator getValidator() {
		return this.validator;
	}
}
