package org.uva.sea.ql.encoders.validation;

public class TypeValidation {

	private final String name;
	private final String errorText;

	public TypeValidation(String name, String errorText) {
		this.name = name;
		this.errorText = errorText;
	}

	public String getName() {
		return name;
	}

	public String getTypeErrorText() {
		return errorText;
	}
}
