package nl.uva.sc.encoders.qlruntime.ui.control;

import java.beans.PropertyChangeEvent;

import javafx.scene.control.TextField;

public class TextFieldPropertyChangeWrapper implements ControlPropertyChangeWrapper {

	private final TextField textField;

	public TextFieldPropertyChangeWrapper(TextField textField) {
		this.textField = textField;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		textField.setText(evt.getNewValue().toString());
	}

	@Override
	public TextField getControl() {
		return textField;
	}

}
