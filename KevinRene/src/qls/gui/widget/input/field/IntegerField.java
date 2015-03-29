package qls.gui.widget.input.field;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.Value;
import ql.value.IntegerValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Field;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class IntegerField extends Field<IntegerValue> implements CaretListener {	
	public IntegerField () {
		super(new IntegerValue(0));
	}
	
	public IntegerField (IntegerValue value) {
		super(value);
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		try {			
			IntegerValue newValue = getFieldValue();
			handleChange(newValue, this);
			removeError();
		}
		catch (NumberFormatException nfe) {
			setError("Not a valid integer");
		}
	}
		
	@Override
	public String convertValue(Value value) {
		if(!value.isNumeric()) {
			throw new TypeMismatchException();
		}
		
		// Fuck me running. Don't look here. Forcing any number into an integer.
		return "" +  Math.round(Float.parseFloat(value.toString()));
	}
	
	@Override
	protected IntegerValue getFieldValue() {
		return new IntegerValue(Integer.parseInt(textField().getText()));
	}
	
	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(textField(), properties);
	}
}
