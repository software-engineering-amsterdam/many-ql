package nl.uva.sc.encoders.ql.validation;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Validation {

	public enum Type {
		WARNING, ERROR;
	}

	private final String validationMessage;

	private final TextLocation textLocation;

	private final Type type;

	public Validation(String validationMessage, TextLocation textLocation, Type type) {
		this.validationMessage = validationMessage;
		this.textLocation = textLocation;
		this.type = type;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("line " + textLocation.getLine());
		builder.append(":" + textLocation.getColumn());
		builder.append(" ");
		builder.append(validationMessage);
		builder.append("\n");
		return builder.toString();
	}
}
