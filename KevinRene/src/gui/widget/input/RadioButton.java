package gui.widget.input;

import gui.widget.InputWidget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JRadioButton;

import cons.value.BooleanValue;

public class RadioButton extends InputWidget<BooleanValue> implements ActionListener {	
	private JRadioButton radioButton;

	public RadioButton() {
		this.radioButton = new JRadioButton();
		this.radioButton.addActionListener(this);
	}
	
	public RadioButton(BooleanValue booleanValue) {
		this.radioButton = new JRadioButton();		
		this.radioButton.setSelected(booleanValue.getValue());
		this.radioButton.addActionListener(this);
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
		handleChange(getValue());
	}
}
