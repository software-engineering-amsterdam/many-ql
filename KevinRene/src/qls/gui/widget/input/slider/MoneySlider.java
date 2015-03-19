package qls.gui.widget.input.slider;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ql.value.FloatValue;
import qls.gui.widget.input.Slider;

/**
 * This class uses some voodoo. JSliders are incapable of dealing with floating point values.
 * So the value of the slider is a money value in CENTS. That value is divided by 100
 * to make it euroes (or so) again.
 * @author kevin
 *
 */
public class MoneySlider extends Slider<FloatValue> implements ChangeListener {
	private final float FACTOR = 100;
	private NumberFormat decimalFormat = new DecimalFormat("#0.00");
	
	public MoneySlider() {
		super();
	}
	public MoneySlider(int min, int max) {
		super(min, max);
	}

	@Override
	public void setValue(FloatValue value) {
		slider.setValue(Math.round((value.getValue() * FACTOR)));
		label.setText(decimalFormat.format(value.getValue()));
	}

	@Override
	public FloatValue getValue() {
		return new FloatValue((float)slider.getValue() / FACTOR);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		handleChange(getValue(), this);
		label.setText(decimalFormat.format(getValue().getValue()));
	}
}
