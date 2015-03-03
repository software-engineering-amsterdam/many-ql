package gui.questions;

import gui.widgets.IWidgetComponent;
import interpreter.Value;
import interpreter.ValueRepository;

import javax.swing.JLabel;

public class ComputedQuestionUI extends SimpleQuestionUI { 
	private String value;
	private final Value expression;
	
	public ComputedQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository, Value expression) {
		super(id, label, wc, valueRepository);
		this.expression = expression;
		this.value = new String("");
		setEnabled(false);
	}

	
	public void setEnabled(boolean enabled) {
		this.getWc().setEnabled(enabled);
	}	


}