package ql.gui.widget.input.spinbox;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import ql.Value;
import ql.gui.widget.input.Spinbox;
import ql.value.MoneyValue;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class MoneySpinbox extends Spinbox<MoneyValue> implements ChangeListener {
	private SpinnerNumberModel model;
	private NumberFormat decimalFormat = new DecimalFormat("#0.00");
	        
	public MoneySpinbox() {
		model = new SpinnerNumberModel(
					0.0, //initial value
	        		0.0, //min
	        		Float.MAX_VALUE, //max
	        		0.1
	        	);
		spinbox = new JSpinner(model);
		spinbox.addChangeListener(this);
		spinbox.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	public MoneySpinbox(MoneyValue moneyValue) {
		this();
		
		disable();
		spinbox.setValue(decimalFormat.format(moneyValue.getValue()));
	}
	
	@Override
	public Number convertValue(Value value) {
		if(!value.isNumeric()) {
			throw new TypeMismatchException();
		}
		
		// Force an ugly cast into a float.
		return Math.round(Float.parseFloat(value.toString()) * 100.0) / 100.0;
	}
	
	@Override
	public MoneyValue getValue() {		
		return new MoneyValue(model.getNumber().floatValue());
	}
}
