package ql.gui.widget.input.field;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.gui.widget.input.Field;
import ql.value.StringValue;

public class TextField extends Field<StringValue> implements CaretListener {	
	public TextField() {
		super(new StringValue(""));
	}
	
	public TextField (StringValue stringValue) {
		super(stringValue);
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		setValue(getFieldValue());
		
		handleChange(getValue(), this);
	}
	
	@Override
	protected StringValue getFieldValue() {
		return new StringValue(textField().getText());
	}
}
