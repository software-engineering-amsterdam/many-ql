package ql.gui.structure;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ql.Value;
import ql.gui.Component;
import ql.value.StringValue;

public class Label implements Component {
	private final JLabel labelComponent;
	
	public Label(StringValue text) {
		this.labelComponent = new JLabel(text.getPrimitive());
	}

	@Override
	public void updateComponent() {
		labelComponent.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return labelComponent;
	}
	
	@Override
	public void setHandler(Component handler) {}

	@Override
	public void handleChange(Value changedValue, Component source) {}
}
