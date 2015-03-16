package gui.widget.input;

import gui.widget.InputWidget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JRadioButton;

import ql.value.BooleanValue;

public class RadioButton extends InputWidget<BooleanValue> implements ActionListener {	
	private JRadioButton radioButton;

	public RadioButton() {
		radioButton = new JRadioButton();
		radioButton.addActionListener(this);
	}
	
	public RadioButton(BooleanValue booleanValue) {
		radioButton = new JRadioButton();		
		radioButton.add(new JRadioButton());
		radioButton.setSelected(booleanValue.getValue());
		radioButton.addActionListener(this);
	}
	
	@Override
	public void disable() {
		radioButton.setEnabled(false);
	}
	
	@Override
	public BooleanValue getValue() {
		return new BooleanValue(radioButton.isSelected());
	}
	
	@Override
	public void setValue(BooleanValue value) {
		radioButton.setSelected(value.getValue());
	}

	@Override
	public void updateComponent() {
		radioButton.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return radioButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handleChange(getValue(), this);
	}
}
