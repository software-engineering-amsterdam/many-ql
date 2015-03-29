package ql.gui.widget.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JRadioButton;

import ql.gui.DefaultComponent;
import ql.gui.widget.InputWidget;
import ql.value.BooleanValue;
import ql.value.StringValue;

public class RadioButton extends DefaultComponent implements InputWidget<BooleanValue>, ActionListener {	
	private JRadioButton radioButton;

	public RadioButton() {
		radioButton = new JRadioButton();
		radioButton.addActionListener(this);
	}
	
	public RadioButton(StringValue radioLabel) {
		radioButton = new JRadioButton(radioLabel.getPrimitive());
		radioButton.addActionListener(this);
	}
	
	public RadioButton(BooleanValue booleanValue) {
		radioButton = new JRadioButton();		
		radioButton.add(new JRadioButton());
		radioButton.setSelected(booleanValue.getPrimitive());
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
		radioButton.setSelected(value.getPrimitive());
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
	
	public BooleanValue isSelected() {
		return new BooleanValue(radioButton.isSelected());
	}
}
