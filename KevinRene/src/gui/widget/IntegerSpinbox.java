package gui.widget;

import gui.Widget;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cons.value.IntegerValue;

public class IntegerSpinbox extends Widget<IntegerValue> implements ChangeListener {
	private SpinnerNumberModel model;
	private JSpinner spinbox;
	        
	public IntegerSpinbox() {
		model = new SpinnerNumberModel(
					0, //initial value
	        		Integer.MIN_VALUE, //min
	        		Integer.MAX_VALUE, //max
	        		1
	        	);
		spinbox = new JSpinner(model);
	}
	
	public IntegerSpinbox(IntegerValue integerValue) {
		model = new SpinnerNumberModel(
					(int) integerValue.getValue(), //initial value
                	integerValue.getValue() - Integer.MAX_VALUE, //min
                	integerValue.getValue() + Integer.MAX_VALUE, //max
                	1
                );
		spinbox = new JSpinner(model);
	}
	
	@Override
	public IntegerValue getValue() {
		return new IntegerValue((int) model.getNumber());
	}

	@Override
	public void setValue(IntegerValue value) {
		spinbox.setValue(value.toString());
		
		setChanged();
		notifyObservers();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println(model.getNumber());
	}

	@Override
	public JComponent getComponent() {
		return spinbox;
	}
}
