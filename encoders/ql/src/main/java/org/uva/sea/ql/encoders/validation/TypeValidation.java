package org.uva.sea.ql.encoders.validation;

import org.uva.sea.ql.encoders.ast.TextLocation;

public class TypeValidation {

	private final String validationMessage;

	private final TextLocation textLocation;

	public TypeValidation(String validationMessage, TextLocation textLocation) {
		this.validationMessage = validationMessage;
		this.textLocation = textLocation;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}
}
