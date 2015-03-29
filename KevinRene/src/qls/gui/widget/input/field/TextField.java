package qls.gui.widget.input.field;

import javax.swing.event.CaretEvent;

import ql.Value;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Field;

public class TextField extends Field<StringValue> {
	public TextField() {
		super(new StringValue(""));
	}
	
	public TextField (StringValue stringValue) {
		super(stringValue);		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		handleChange(getFieldValue(), this);
	}

	@Override
	protected StringValue getFieldValue() {
		return new StringValue(textField().getText());
	}
	
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(textField(), properties);
	}

	@Override
	public String convertValue(Value value) {
		return value.getPrimitive().toString();
	}
}
