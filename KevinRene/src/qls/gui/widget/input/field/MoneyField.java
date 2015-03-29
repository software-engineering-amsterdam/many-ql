package qls.gui.widget.input.field;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.Value;
import ql.value.MoneyValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Field;

public class MoneyField extends Field<MoneyValue> implements CaretListener {
	private NumberFormat decimalFormat =
			NumberFormat.getCurrencyInstance(new Locale("NL", "nl"));
	
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
		catch (ParseException pe) {
			setError(pe.getMessage());
		}
	}
	
	@Override
	protected MoneyValue getFieldValue() throws ParseException {
		String text = textField().getText();
		
		if (text.contains(".")) {
			throw new ParseException("The . is not allowed.", 
					textField().getText().indexOf("."));
		}
		
		return new MoneyValue(
				decimalFormat.parse(text).floatValue()
			);
	}
	
	@Override
	public String convertValue(Value value) {
		return decimalFormat.format(value.getPrimitive());	
	}
}
