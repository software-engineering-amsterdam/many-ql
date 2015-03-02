package gui.widget;

import gui.Widget;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cons.value.BooleanValue;

public class RadioButton extends Widget<BooleanValue> implements ChangeListener {	
	private JRadioButton radioButton;
	private BooleanValue booleanValue;

	public RadioButton() {
		radioButton = new JRadioButton();
	}
	
	public RadioButton(BooleanValue booleanValue) {
		this.booleanValue = booleanValue;
		
		radioButton = new JRadioButton();		
		radioButton.setSelected(this.booleanValue.getValue());
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
	public void stateChanged(ChangeEvent e) {
		setChanged();
		notifyObservers();
	}
}
