package qls.gui.widget.input.field;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.value.FloatValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.statement.widget.styling.property.Font;
import qls.gui.widget.input.Field;

public class FloatField extends Field<FloatValue> implements CaretListener {	
	public FloatField () {
		super(new FloatValue(0f));
	}
	public FloatField (FloatValue value) {
		super(value);
	}
	
	@Override
	public void setStyle(StyleProperties properties) {
		textField.setSize(textField.getWidth(), textField.getHeight());
	}
	
	@Override
	protected void setFont(Font font) {
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
		return new FloatValue(Float.parseFloat(textField.getText()));
	}
}
