package qls.gui.widget.input.field;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.value.IntegerValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.statement.widget.styling.property.Font;
import qls.gui.widget.input.Field;

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
	protected IntegerValue getFieldValue() {
		return new IntegerValue(Integer.parseInt(textField.getText()));
	}
	
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(textField, properties);
	}
	@Override
	protected void setFont(Font font) {
		// TODO Auto-generated method stub
		
	}
}
