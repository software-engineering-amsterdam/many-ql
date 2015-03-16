package nl.uva.se.gui.widgets.questions;

import nl.uva.se.gui.listeners.Listener;
import nl.uva.se.gui.validators.IntegerValidator;
import nl.uva.se.ql.ast.statement.Question;
import javafx.scene.control.TextField;

public class IntegerQuestion extends TextField implements BaseQuestion<String> {

	private final Question question;
	private final IntegerValidator validator;
	private final Listener<String> listener;

	public IntegerQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new IntegerValidator();
		this.listener = new Listener<String>();
		this.textProperty().addListener(listener.addListener(this, validator));
	}

	public Question getQuestion() {
		return this.question;
	}

	public IntegerValidator getValidator() {
		return this.validator;
	}

	public void undoChange(String oldValue) {
		this.setText(oldValue);
	}

	public void reset() {
		this.setText("");
	}
}
