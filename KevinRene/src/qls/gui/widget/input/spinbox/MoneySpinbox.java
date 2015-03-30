package qls.gui.widget.input.spinbox;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import ql.Value;
import ql.value.MoneyValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Spinbox;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class MoneySpinbox extends Spinbox<MoneyValue> implements ChangeListener {
	private NumberFormat decimalFormat = 
			NumberFormat.getCurrencyInstance(new Locale("NL", "nl"));
	
	public MoneySpinbox() {
		super(new SpinnerNumberModel(
					0.0, //initial value
	        		0.0, //min
	        		Float.MAX_VALUE, //max
	        		0.1
	        	));
	}
	
	public MoneySpinbox(MoneyValue moneyValue) {
		this();
		
		disable();
		spinbox().setValue(decimalFormat.format(moneyValue.getPrimitive()));
	}
	
	@Override
	public Number convertValue(Value value) {
		if(!value.isNumeric()) {
			setError("Not a valid number!");
			throw new TypeMismatchException();
		}
		removeError();
		
		// Force an ugly cast into a float.
		return Math.round(Float.parseFloat(value.toString()) * 100.0) / 100.0;
	}
	
	@Override
	public MoneyValue getValue() {		
		return new MoneyValue(model().getNumber().floatValue());
	}
	
	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(spinbox(), properties);
	}
}
