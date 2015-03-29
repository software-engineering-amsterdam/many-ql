package ql.gui.widget.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import ql.gui.DefaultComponent;
import ql.gui.widget.InputWidget;
import ql.value.UndefinedValue;

public class Button extends DefaultComponent implements InputWidget<UndefinedValue>, ActionListener {
	private JButton button;
	
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
	public void actionPerformed(ActionEvent e) {
		handleChange(new UndefinedValue(), this);
	}	
}
