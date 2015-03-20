package nl.uva.sc.encoders.qlruntime.ui.control;

import java.beans.PropertyChangeEvent;

import javafx.scene.control.CheckBox;
import nl.uva.sc.encoders.qlruntime.model.value.BooleanValue;

public class CheckBoxPropertyChangeWrapper implements ControlPropertyChangeWrapper {

	private final CheckBox checkBox;

	public CheckBoxPropertyChangeWrapper(CheckBox checkBox) {
		this.checkBox = checkBox;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		checkBox.setSelected(((BooleanValue) evt.getNewValue()).getValue());
	}

	@Override
	public CheckBox getControl() {
		return checkBox;
	}
}
