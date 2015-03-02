package gui.questions;

import gui.widgets.IWidgetComponent;
import interpreter.ValueRepository;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private ValueRepository valueRepository;
	private String value;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository) {
		this.id = id;
		this.label = label;
		this.wc = wc;
		this.valueRepository = valueRepository;
		this.wc.addDocListener();
		this.value = new String("");
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
	
	
	
	public String getValue() {
		System.out.println("UI" + value);
		return value;
		
	}
	
	public void setValue() {
		value = valueRepository.getValue(id).toString();
	}

}