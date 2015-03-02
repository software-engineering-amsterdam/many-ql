package gui.widget;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.value.UndefinedValue;
import gui.Widget;

public class Panel extends Widget<UndefinedValue> {
	private JPanel panel;
	
	public Panel() {
		this.panel = new JPanel();
	}
	
	@SuppressWarnings("rawtypes")
	public void addComponent(Widget component) {
		panel.add(component.getComponent());
	}
	
	@Override
	public UndefinedValue getValue() {
		return new UndefinedValue();
	}

	@Override
	public void setValue(UndefinedValue value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public JComponent getComponent() {
		return panel;
	}	
}
