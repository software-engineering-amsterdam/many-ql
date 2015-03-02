package org.uva.ql.typecheck.message;

public class Warning extends Message {
	
	public enum Type {
		DUPLICATE,        // duplicate labels
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
		
		default:
			content = "Unknow error";
			break;
		}
		
		return "Warning@line" + lineNumber + ": " + content;
	}
}
