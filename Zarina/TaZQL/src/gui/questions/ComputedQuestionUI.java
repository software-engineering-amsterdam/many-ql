package gui.questions;

import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class ComputedQuestionUI extends SimpleQuestionUI { 
	
	public ComputedQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository, Value expression) {
		super(id, label, wc, valueRepository);
		this.setValue(expression);
		this.getWc().setEnabled(false); // read-only
	}
}