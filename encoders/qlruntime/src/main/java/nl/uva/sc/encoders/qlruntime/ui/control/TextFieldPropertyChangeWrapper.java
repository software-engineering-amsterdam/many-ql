package nl.uva.sc.encoders.qlruntime.ui.control;

import java.beans.PropertyChangeEvent;

import javafx.scene.control.TextField;
import nl.uva.sc.encoders.qlruntime.model.value.StringValue;

public class TextFieldPropertyChangeWrapper implements ControlPropertyChangeWrapper {

	private final TextField textField;

	public TextFieldPropertyChangeWrapper(TextField textField) {
		this.textField = textField;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		textField.setText(((StringValue) evt.getNewValue()).getValue());
	}

	@Override
	public TextField getControl() {
		return textField;
	}

}
