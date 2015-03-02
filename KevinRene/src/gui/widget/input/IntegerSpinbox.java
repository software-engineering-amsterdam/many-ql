package gui.widget.input;

import gui.widget.InputWidget;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cons.value.IntegerValue;

public class IntegerSpinbox extends InputWidget<IntegerValue> implements ChangeListener {
	private SpinnerNumberModel model;
	private JSpinner spinbox;
	        
	public IntegerSpinbox() {
		model = new SpinnerNumberModel(
					0, //initial value
	        		0, //min
	        		Integer.MAX_VALUE, //max
	        		1
	        	);
		spinbox = new JSpinner(model);
		spinbox.addChangeListener(this);
		spinbox.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	public IntegerSpinbox(IntegerValue integerValue) {
		model = new SpinnerNumberModel(
					(int) integerValue.getValue(), //initial value
                	0, //min
                	integerValue.getValue() + Integer.MAX_VALUE, //max
                	1
                );
		spinbox = new JSpinner(model);
		spinbox.addChangeListener(this);
		spinbox.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		disable();
		spinbox.setValue(integerValue.getValue());
	}
	
	@Override
	public void disable() {
		spinbox.setEnabled(false);
	}
	
	@Override
	public IntegerValue getValue() {		
		return new IntegerValue((int) model.getNumber());
	}

	@Override
	public void setValue(IntegerValue value) {
		spinbox.setValue(value.getValue());
	}

	@Override
	public JComponent getComponent() {
		spinbox.repaint();
		
		return spinbox;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		setChanged();
		notifyObservers(getValue());
	}
}
