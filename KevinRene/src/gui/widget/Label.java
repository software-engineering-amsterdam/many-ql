package gui.widget;

import gui.Widget;

import javax.swing.JComponent;
import javax.swing.JLabel;

import cons.value.StringValue;

public class Label extends Widget {
	private final JLabel labelComponent;
	
	public Label(StringValue text) {
		this.labelComponent = new JLabel(text.getValue());
	}
	
	@Override
	public JComponent getComponent() {
		return labelComponent;
	}	
}
