package ql.gui.widget.input.spinner;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import ql.Value;
import ql.gui.widget.input.Spinner;
import ql.value.IntegerValue;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class IntegerSpinner extends Spinner<IntegerValue> implements ChangeListener {
	        
	public IntegerSpinner() {
		super(new SpinnerNumberModel(
					0, //initial value
	        		0, //min
	        		Integer.MAX_VALUE, //max
	        		1
	        	));
	}
	
	public IntegerSpinner(IntegerValue integerValue) {
		this();
		
		disable();
		spinbox.setValue(integerValue.getValue());
	}
	
	@Override
	public Number convertValue(Value value) {
		if(!value.isNumeric()) {
			throw new TypeMismatchException();
		}
		
		// Fuck me running. Don't look here. Forcing any number into an integer.
		return Math.round(Float.parseFloat(value.toString()));
	}
	
	@Override
	public IntegerValue getValue() {		
		return new IntegerValue(model.getNumber().intValue());
	}
}
