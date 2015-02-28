package org.uva.sea.ql.encoders.ast;

/**
 * Represents an error of the TypeChecker
 */
public class TypeError {

	private final String name;

	private final String errorText;

	public TypeError(String name, String errorText) {
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
