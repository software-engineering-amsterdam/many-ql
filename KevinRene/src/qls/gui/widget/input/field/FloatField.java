package qls.gui.widget.input.field;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.Value;
import ql.value.FloatValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Field;

public class FloatField extends Field<FloatValue> implements CaretListener {	
	public FloatField () {
		super(new FloatValue(0f));
	}
	
	public FloatField (FloatValue value) {
		super(value);
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		try {			
			FloatValue newValue = getFieldValue();
			handleChange(newValue, this);
			removeError();
		}
		catch (NumberFormatException nfe) {
			setError("Not a valid float");
		}
	}
	
	@Override
	protected FloatValue getFieldValue() {
		return new FloatValue(Float.parseFloat(textField().getText()));
	}
	
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(textField(), properties);
	}

	@Override
	public String convertValue(Value value) {
		return value.toString();
	}
}
