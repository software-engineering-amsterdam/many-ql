package gui.questions;

import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class ComputedQuestionUI extends SimpleQuestionUI { 
	private String value;
	private final Value expression;
	
	public ComputedQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository, Value expression) {
		super(id, label, wc, valueRepository);
		this.expression = expression;
		this.value = new String("");
		this.getWc().setEnabled(false);
	}

	
	public void setEnabled(boolean enabled) {
		this.getWc().setEnabled(enabled);
		this.getWc().getWidget().setEnabled(enabled);
	}	

	//public void set
}