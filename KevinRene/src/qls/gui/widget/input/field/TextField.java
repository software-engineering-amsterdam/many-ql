package qls.gui.widget.input.field;

import javax.swing.JTextField;

import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.statement.widget.styling.property.Font;
import qls.gui.widget.input.Field;

public class TextField extends Field<StringValue> {
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

	@Override
	public void setStyle(StyleProperties properties) {
		
	}

	@Override
	public void setFont(Font font) {
		
	}
}
