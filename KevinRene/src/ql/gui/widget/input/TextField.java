package ql.gui.widget.input;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import ql.value.StringValue;

public class TextField extends Field<StringValue> implements CaretListener {	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
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
