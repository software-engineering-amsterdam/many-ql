package qls.gui.widget.input.slider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ql.value.IntegerValue;
import qls.gui.widget.input.Slider;

public class IntegerSlider extends Slider<IntegerValue> implements ChangeListener {

	public IntegerSlider() {
		super();
	}
	public IntegerSlider(int min, int max) {
		super(min, max);
	}

	@Override
	public void setValue(IntegerValue value) {
		slider.setValue(value.getValue());
		label.setText(value.toString());
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue(slider.getValue());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		handleChange(getValue(), this);
		label.setText(getValue().toString());
	}
}
