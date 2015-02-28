package gui.questions;

import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IConnector { 
	private final String id, label;
	private final IWidgetComponent wc;
	//private String value;
	
	public SimpleQuestionUI(String id, String label, IWidgetComponent wc) {
		this.id = id;
		this.label = label;
		this.wc = wc;
	}

	public JLabel createdLabel() {
		JLabel id = new JLabel(label);
		return id;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public IWidgetComponent getWc() {
		return wc;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		wc.setValue(value);
		
	}
	
	public String getValue() {
		return wc.getValue();
	}
}