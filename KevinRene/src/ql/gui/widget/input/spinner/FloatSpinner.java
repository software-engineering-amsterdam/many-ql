package ql.gui.widget.input.spinner;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import ql.Value;
import ql.gui.widget.input.Spinner;
import ql.value.FloatValue;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class FloatSpinner extends Spinner<FloatValue> implements ChangeListener {
	private SpinnerNumberModel model;
	        
	public FloatSpinner() {
		super(new SpinnerNumberModel(
				0.0, //initial value
        		0.0, //min
        		Float.MAX_VALUE, //max
        		0.1
        	));
	}
	
	public FloatSpinner(FloatValue floatValue) {
		this();
		
		disable();
		spinbox.setValue(floatValue.getValue());
	}
	
	@Override
	public Number convertValue(Value value) {
		if(!value.isNumeric()) {
			throw new TypeMismatchException();
		}
		
		// Force an ugly cast into a float.
		return Float.parseFloat(value.toString());
	}
	
	@Override
	public FloatValue getValue() {		
		return new FloatValue(model.getNumber().floatValue());
	}
}
