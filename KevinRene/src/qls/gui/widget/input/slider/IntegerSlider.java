package qls.gui.widget.input.slider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ql.value.IntegerValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Slider;

public class IntegerSlider extends Slider<IntegerValue> implements ChangeListener {
	public IntegerSlider(IntegerValue minValue, IntegerValue maxValue) {
		super(minValue, maxValue);
	}

	@Override
	public void setValue(IntegerValue value) {
		slider.setValue(value.getPrimitive());
		label.setText(value.toString());
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue(slider.getValue());
	}

	@Override
	public void updateComponent() {
		label.setText(getValue().toString());
		super.updateComponent();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		handleChange(getValue(), this);
	}

	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(slider, properties);
	}
}
