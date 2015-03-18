package nl.uva.sc.encoders.qls.validation;

import nl.uva.sc.encoders.qls.ast.TextLocation;

public class Validation {

	private final String validationMessage;

	private final TextLocation textLocation;

	public Validation(String validationMessage, TextLocation textLocation) {
		this.validationMessage = validationMessage;
		this.textLocation = textLocation;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public TextLocation getTextLocation() {
		return textLocation;
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
