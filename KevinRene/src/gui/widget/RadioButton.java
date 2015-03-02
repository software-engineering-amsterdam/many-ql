package gui.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Widget;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cons.value.BooleanValue;

public class RadioButton extends Widget<BooleanValue> implements ActionListener {	
	private JRadioButton radioButton;
	private BooleanValue booleanValue;

	public RadioButton() {
		this.booleanValue = new BooleanValue(false);
		this.radioButton = new JRadioButton();
		this.radioButton.addActionListener(this);
	}
	
	public RadioButton(BooleanValue booleanValue) {
		this.booleanValue = booleanValue;
		
		this.radioButton = new JRadioButton();		
		this.radioButton.setSelected(this.booleanValue.getValue());
		this.radioButton.addActionListener(this);
	}
	
	@Override
	public BooleanValue getValue() {
		return booleanValue;
	}
	
	@Override
	public void setValue(BooleanValue value) {
		this.booleanValue = value;
		radioButton.setSelected(this.booleanValue.getValue());
		
		setChanged();
		notifyObservers();
	}

	@Override
	public JComponent getComponent() {
		return radioButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setChanged();
		notifyObservers();
	}
}
