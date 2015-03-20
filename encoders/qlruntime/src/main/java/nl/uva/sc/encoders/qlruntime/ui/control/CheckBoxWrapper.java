package nl.uva.sc.encoders.qlruntime.ui.control;

import java.beans.PropertyChangeEvent;

import javafx.scene.control.CheckBox;
import nl.uva.sc.encoders.qlruntime.value.BooleanValue;

public class CheckBoxWrapper implements ControlWrapper {

	private final CheckBox checkBox;

	public CheckBoxWrapper(CheckBox checkBox) {
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
