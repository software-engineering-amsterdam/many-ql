package gui.questions;

import evaluator.BooleanValue;
import evaluator.Value;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private Value value; 
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc) {
		this.id = id;
		this.label = label;
		this.wc = wc;
	}

	public String getId() {
		return id;
	}

	public JLabel getLabel() {
		return label;
	}

	public IWidgetComponent getWc() {
		return wc;
	}

	
	@Override
	public void setValue(Value value) {
		this.value = value;
		this.wc.setValue(value);
		this.wc.setVisible(true);
	}

	@Override
	public void setVisibilityValue(Value value) {
		boolean visibility = Boolean.parseBoolean(value.toString());
		this.wc.setVisible(visibility);
		this.label.setVisible(visibility);
	}
}