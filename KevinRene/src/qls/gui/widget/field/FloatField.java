package qls.gui.widget.field;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import ql.gui.widget.input.Field;
import ql.value.FloatValue;

public class FloatField extends Field<FloatValue> implements CaretListener {	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
	public FloatField () {
		super();
	}
	public FloatField (FloatValue value) {
		super();		
    	textField.setText(value.getValue().toString());	
	}

	@Override
	public FloatValue getValue() {
		return new FloatValue(Float.parseFloat(textField.getText()));
	}
	
	@Override
	public void setValue(FloatValue value) {
		textField.setText(value.toString());		
	}
}
