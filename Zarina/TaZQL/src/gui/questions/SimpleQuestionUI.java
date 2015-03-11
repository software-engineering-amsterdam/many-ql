package gui.questions;

import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	//private ValueRepository valueRepository;
	private Value value;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc) {
		this.id = id;
		this.label = label;
		this.wc = wc;
	//	this.valueRepository = valueRepository;
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
		this.wc.setText(value);
	}
	
	public Value getValue(){
		return this.value;
	}

	@Override
	public void setVisibilityValue(Value value) {
		boolean visibility = Boolean.parseBoolean(value.toString());
		//if ( value != null) {
			//boolean visibility = Boolean.parseBoolean(value.toString());
			this.wc.setVisible(visibility);
			this.label.setVisible(visibility);
		//} 
		
		//this.wc.setVisible(false);
		// TODO Auto-generated method stub
		//return false;
	}
}