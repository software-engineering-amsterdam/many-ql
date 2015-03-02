package org.uva.sea.ql.encoders.validation;

import org.uva.sea.ql.encoders.ast.TextLocation;

public class TypeValidation {

	private final String errorText;

	private final TextLocation textLocation;

	public TypeValidation(String errorText, TextLocation textLocation) {
		this.errorText = errorText;
		this.textLocation = textLocation;
	}

	public String getTypeErrorText() {
		return errorText;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}
}
