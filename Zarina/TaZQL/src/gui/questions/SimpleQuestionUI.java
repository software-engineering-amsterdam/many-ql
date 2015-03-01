package gui.questions;

import gui.widgets.IWidgetComponent;
import gui.widgets.TextDigitsListener;

import javax.swing.JLabel;

public class SimpleQuestionUI implements IConnector { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private String value;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc) {
		this.id = id;
		this.label = label;
		this.wc = wc;
	}

	public String getId() {
		return id;
	}

	public JLabel getLabel() {
		label.setVisible(true);
		return label;
	}

	public IWidgetComponent getWc() {
		return wc;
	}
	

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		
		this.wc.setValue(value);
		
	}
	
}