package gui.widget.input.spinbox;

import gui.widget.input.Spinbox;

import java.awt.Component;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import ql.Value;
import ql.value.IntegerValue;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class IntegerSpinbox extends Spinbox<IntegerValue> implements ChangeListener {
	private SpinnerNumberModel model;
	        
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
		this();
		
		disable();
		spinbox.setValue(integerValue.getValue());
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Value convertValue(Value value) {
		if(!value.isNumeric()) {
			throw new TypeMismatchException();
		}
		
		// Fuck me running. Don't look here. Forcing any number into an integer.
		return new IntegerValue(Math.round((float) value.getValue()));
	}
	
	@Override
	public IntegerValue getValue() {		
		return new IntegerValue(model.getNumber().intValue());
	}
}
