package ql.gui.widget.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import ql.Value;
import ql.gui.UIComponent;
import ql.gui.widget.InputWidget;
import ql.value.UndefinedValue;

public class Button implements InputWidget<UndefinedValue>, ActionListener {
	private JButton button;
	private UIComponent handler;
	
	public Button(String buttonText) {
		button = new JButton(buttonText);
		button.addActionListener(this);
	}
	
	@Override
	public void disable() {
		button.setEnabled(false);
	}

	@Override
	public void setValue(UndefinedValue value) {}

	@Override
	public UndefinedValue getValue() {
		return new UndefinedValue();
	}

	@Override
	public void updateComponent() {
		button.revalidate();
		button.repaint();
	}

	@Override
	public JComponent getComponent() {
		return button;
	}

	@Override
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		handler.handleChange(changedValue, source);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		handleChange(new UndefinedValue(), this);
	}	
}
