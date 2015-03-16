package nl.uva.se.ql.gui.widgets.questions;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.validators.BooleanValidator;
import javafx.scene.control.CheckBox;

public class BooleanQuestion extends CheckBox implements BaseQuestion<Boolean>{

	private final Question question;
	private final BooleanValidator validator;
	private final Listener<Boolean> listener;	

	public BooleanQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new BooleanValidator();
		this.listener = new Listener<Boolean>();		
		this.selectedProperty().addListener(listener.addListener(this, validator));
	}

	public Question getQuestion() {
		return this.question;
	}

	public BooleanValidator getValidator() {
		return this.validator;
	}
	
	public void reset() {
		this.setSelected(false);		
	}

	@Override
	public Boolean undoChange(Boolean newValue, Boolean oldValue) {
		return newValue;		
	}
}
