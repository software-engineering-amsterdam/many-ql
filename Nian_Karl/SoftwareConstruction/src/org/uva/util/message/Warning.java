package org.uva.util.message;

public class Warning extends Message {

	public enum Type {
		DUPLICATE, // duplicate labels
		INVALID_INPUT, DUPLICATED_VALUES, BELOW_ZERO, UNDEFINED
	}

	private final Type type;

	public Warning(Type type, int lineNumber, String literal) {
		super(lineNumber, literal);
		this.type = type;
	}

	@Override
	public String toString() {
		String content;
		switch (type) {
		case DUPLICATE:
			content = "Label <" + literal + "> is duplicated.";
			break;
		case INVALID_INPUT:
			content = "Input <" + literal + "> is invalid. ";
			break;
		case DUPLICATED_VALUES:
			content = "Input <" + literal + "> is duplicated in it's list. ";
			break;
		case BELOW_ZERO:
			content = "Input <" + literal + "> can't be lower than zero. ";
			break;
		case UNDEFINED:
			content = "Input <" + literal + "> is undefined. ";
			break;
			
		default:
			content = "Unknow error";
			break;
		}
		return "Warning@line" + lineNumber + ": " + content;
	}
}
