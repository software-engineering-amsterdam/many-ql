package qls.gui.widget.input.field;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import ql.value.FloatValue;
import qls.ast.statement.styling.StyleProperties;
import qls.ast.statement.styling.property.Font;
import qls.gui.widget.input.Field;

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
	
	@Override
	public void setStyle(StyleProperties properties) {
	}
	
	@Override
	public void setFont(Font font) {
	}
}
