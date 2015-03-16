package nl.uva.se.ql.gui.widgets.questions;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.validators.TextValidator;
import javafx.scene.control.TextField;

public class TextQuestion extends TextField implements BaseQuestion<String> {

	private final Question question;
	private final TextValidator validator;
	private final Listener<String> listener;

	public TextQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new TextValidator();
		this.listener = new Listener<String>();
		this.textProperty().addListener(listener.addListener(this, validator));
	}

	public Question getQuestion() {
		return this.question;
	}

	public TextValidator getValidator() {
		return this.validator;
	}

	@Override
	public void undoChange(String oldValue) {
		this.setText(oldValue);		
	}

	@Override
	public void reset() {
		this.setText("");		
	}
}
