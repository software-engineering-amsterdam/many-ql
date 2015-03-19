package ql.gui.widget.input.field;

import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import ql.gui.widget.input.Field;
import ql.value.StringValue;

public class TextField extends Field<StringValue> implements CaretListener {	
	private JTextField textField;
	
	public TextField() {
		super();
	}
	
	public TextField (StringValue stringValue) {
		super();		
    	textField.setText(stringValue.getValue());	
	}
	
	@Override
	public StringValue getValue() {
		return new StringValue(textField.getText());
	}
	
	@Override
	public void setValue(StringValue value) {
		textField.setText(value.toString());		
	}
}
