package org.uva.sea.ql.encoders.ui;

import java.beans.PropertyChangeEvent;

import javafx.scene.control.TextField;

public class TextFieldWrapper implements ControlWrapper {

	private final TextField textField;

	public TextFieldWrapper(TextField textField) {
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
