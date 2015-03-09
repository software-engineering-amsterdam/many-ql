package gui.questions;

import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private ValueRepository valueRepository;
	//private String value;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository) {
		this.id = id;
		this.label = label;
		this.wc = wc;
		this.valueRepository = valueRepository;
		this.wc.addDocListener();
		//this.value = new String("");
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
	public void setValue(String value) {
		value = valueRepository.getValue(id).toString();
	}

}