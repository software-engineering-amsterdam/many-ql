package nl.uva.sc.encoders.qlruntime.ui.control;

import java.beans.PropertyChangeEvent;

import nl.uva.sc.encoders.qlruntime.model.value.IntegerValue;

public class NumberFieldPropertyChangeWrapper implements ControlPropertyChangeWrapper {

	private final NumberField numberField;

	public NumberFieldPropertyChangeWrapper(NumberField numberField) {
		this.numberField = numberField;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		numberField.setNumber(((IntegerValue) evt.getNewValue()).getValue());
	}

	@Override
	public NumberField getControl() {
		return numberField;
	}

}
