package gui.questions;

import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private ValueRepository valueRepository;
	private Value value;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository) {
		this.id = id;
		this.label = label;
		this.wc = wc;
		this.valueRepository = valueRepository;
		//this.wc.addDocListener();
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
		wc.setText(value);

		// update the widget setText with value from value repo
//		value = valueRepository.getValue(id).toString();
	}
	public Value getValue(){
		return this.value;
	}
}