package qls.gui.widget.input.spinbox;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import ql.Value;
import ql.value.FloatValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Spinbox;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class FloatSpinbox extends Spinbox<FloatValue> implements ChangeListener {
	public FloatSpinbox() {
		super(new SpinnerNumberModel(
				0.0, //initial value
        		0.0, //min
        		Float.MAX_VALUE, //max
        		0.1
        	));
	}
	
	public FloatSpinbox(FloatValue floatValue) {
		this();
		
		disable();
		spinbox().setValue(floatValue.getPrimitive());
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
		return new FloatValue(model().getNumber().floatValue());
	}

	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(spinbox(), properties);
	}
}
