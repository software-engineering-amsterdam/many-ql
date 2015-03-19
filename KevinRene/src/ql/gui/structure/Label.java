package ql.gui.structure;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ql.Value;
import ql.gui.UIComponent;
import ql.value.StringValue;

public class Label implements UIComponent {
	private final JLabel labelComponent;
	
	public Label(StringValue text) {
		this.labelComponent = new JLabel(text.getValue());
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
	public void setHandler(UIComponent handler) {}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {}
}
