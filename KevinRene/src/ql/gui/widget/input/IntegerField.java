package ql.gui.widget.input;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import ql.value.IntegerValue;

public class IntegerField extends Field<IntegerValue> implements CaretListener {	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
	public IntegerField () {
		super();
	}
	public IntegerField (IntegerValue value) {
		super();		
    	textField.setText(value.getValue().toString());	
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue(Integer.parseInt(textField.getText()));
	}
	
	@Override
	public void setValue(IntegerValue value) {
		textField.setText(value.toString());		
	}
}
