package gui.widget;

import gui.Widget;

import javax.swing.JComponent;
import javax.swing.JLabel;

import cons.value.StringValue;

public class Label extends Widget<StringValue> {
	private final JLabel labelComponent;
	
	public Label(StringValue text) {
		this.labelComponent = new JLabel(text.getValue());
	}

	@Override
	public void setValue(StringValue value) {
		labelComponent.setText(value.getValue());
	}
	
	@Override
	public StringValue getValue() {
		return new StringValue(labelComponent.getText());
	}
	
	@Override
	public JComponent getComponent() {
		return labelComponent;
	}	
}
