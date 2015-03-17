package nl.uva.se.ql.gui.widgets.questions;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.validators.IntegerValidator;
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

	public void reset() {
		this.setText("");
	}

	@Override
	public String undoChange(String newValue, String oldValue) {
		if (oldValue.equals("")) {
			oldValue = "0";
		} 
		this.setText(oldValue);
		return this.getText();
	}
}
