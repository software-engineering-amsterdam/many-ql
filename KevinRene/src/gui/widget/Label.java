package gui.widget;

import gui.Widget;

import javax.swing.JComponent;
import javax.swing.JLabel;

import cons.Value;
import cons.value.StringValue;

public class Label implements Widget {
	private final JLabel labelComponent;
	
	public Label(StringValue text) {
		this.labelComponent = new JLabel(text.getValue());
	}

	@Override
	public void setHandler(Widget handler) {}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue) {}
	
	@Override
	public void updateComponent() {
		labelComponent.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return labelComponent;
	}
}
