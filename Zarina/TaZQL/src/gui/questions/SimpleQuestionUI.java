package gui.questions;

import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private final ValueRepository valueRepository;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository) {
		this.id = id;
		this.label = label;
		this.wc = wc;
		this.valueRepository = valueRepository;
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