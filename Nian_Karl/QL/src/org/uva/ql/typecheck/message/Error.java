package org.uva.ql.typecheck.message;

public class Error extends Message {

	public enum Type {
		REFERENCE,        // reference to undefined questions
		DECLARATION,      // duplicate question declarations with different types
		CONDITION,        // conditions that are not of the type boolean
		MISMATCH,          // operands of invalid type to operators
		CYCLIC;           // cyclic dependencies between questions
	}
	
	private final Type type;
	private final String expectType;
	
	
	public Error(Type type, int lineNumber, String literal, String expectType) {
		super(lineNumber, literal);
		this.type = type;
		this.expectType = expectType;
	}
	
	public Error(Type type, int lineNumber, String literal) {
		this(type, lineNumber, literal, "");
	}
	
	@Override
	public String toString() {
		String content;
		switch (type) {
		case REFERENCE:
			content = "Question <" + literal + 	"> is undefined.";
			break;
		case DECLARATION:
			content = "Question <" + literal + "> is declared with different types.";
			break;
		case MISMATCH:
			content = "<" + literal + "> is expected to be <" + expectType + ">.";
			break;
		case CYCLIC:
			content = "<" + literal + "> has cyclic dependency error.";
			break;
		default:
			content = "Unknow error";
			break;
		}
		return "Error@line" + lineNumber + ": " + content; 
	}
	
}
