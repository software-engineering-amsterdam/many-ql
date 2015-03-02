package gui.questions;

import gui.widgets.IWidgetComponent;
import interpreter.ValueRepository;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private ValueRepository valueRepository;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc, ValueRepository valueRepository) {
		this.id = id;
		this.label = label;
		this.wc = wc;
		this.valueRepository = valueRepository;
		this.wc.addDocListener(valueRepository);
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
		System.out.println("UI" + valueRepository.getValue(id));
		return valueRepository.getValue(id).toString();
		
	}

}