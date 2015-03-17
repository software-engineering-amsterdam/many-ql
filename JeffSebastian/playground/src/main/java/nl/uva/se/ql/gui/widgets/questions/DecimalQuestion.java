package nl.uva.se.ql.gui.widgets.questions;

import javafx.scene.control.TextField;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.validators.DecimalValidator;
import nl.uva.se.ql.gui.validators.IntegerValidator;

public class DecimalQuestion extends TextField implements BaseQuestion<String> {
	private final Question question;
	private final DecimalValidator validator;
	private final Listener<String> listener;

	public DecimalQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new DecimalValidator();
		this.listener = new Listener<String>();
		this.textProperty().addListener(listener.addListener(this, validator));
	}

	public Question getQuestion() {
		return this.question;
	}

	public DecimalValidator getValidator() {
		return this.validator;
	}

	@Override
	public void reset() {
		this.setText("");
	}

	@Override
	public String undoChange(String newValue, String oldValue) {
		IntegerValidator integerValidator = new IntegerValidator();
		if (integerValidator.isValid(newValue)) {
			this.setText(newValue + ".00");
			return this.getText();
		}
		if (newValue.isEmpty() || !integerValidator.isValid(newValue)
				&& oldValue.isEmpty()) {
			this.setText("0.00");
			return this.getText();
		}
		this.setText(oldValue);
		return this.getText();
	}
}
