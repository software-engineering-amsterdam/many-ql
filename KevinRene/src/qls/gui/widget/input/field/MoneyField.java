package qls.gui.widget.input.field;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.Value;
import ql.value.MoneyValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Field;

public class MoneyField extends Field<MoneyValue> implements CaretListener {
	private NumberFormat decimalFormat = new DecimalFormat("#0,00");
	
	public MoneyField () {
		super(new MoneyValue(0f));
	}
	
	public MoneyField (MoneyValue value) {
		super(value);
	}
	
	@Override
	public void setStyle(StyleProperties properties) {
		textField().setSize(textField().getWidth(), textField().getHeight());
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		try {			
			MoneyValue newValue = getFieldValue();
			handleChange(newValue, this);
			removeError();
		}
		catch (NumberFormatException nfe) {
			setError("Not a valid money value");
		}
	}
	
	@Override
	protected MoneyValue getFieldValue() {
		return new MoneyValue(
				Math.round(Float.parseFloat(textField().getText()) * 100.0) / 100.0f
			);
	}
	
	@Override
	public String convertValue(Value value) {
		return decimalFormat.format(value.getValue());	
	}
}
