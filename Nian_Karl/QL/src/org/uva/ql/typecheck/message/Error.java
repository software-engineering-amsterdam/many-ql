package org.uva.ql.typecheck.message;

public class Error extends Message {

	public enum Type {
		UNDEFINED,        // reference to undefined questions
		DECLARATION,      // duplicate question declarations with different types
		CONDITION,        // conditions that are not of the type boolean
		OPERAND,          // operands of invalid type to operators
		CYCLIC;           // cyclic dependencies between questions
	}
	
	private final Type type;
	private final String literalOption;		// for cyclic dependency, e.g. Id1 and Id2 are cyclic dependent.
	
	
	public Error(Type type, int lineNumber, String literal, String literalOption) {
		super(lineNumber, literal);
		this.type = type;
		this.literalOption = literalOption;
	}
	
	public Error(Type type, int lineNumber, String literal) {
		this(type, lineNumber, literal, "");
	}
	
	@Override
	public String toString() {
		
		String content;
		switch (type) {
		case UNDEFINED:
			content = "Reference to undefined question <" + literal + 	">.";
			break;
		
		case DECLARATION:
			content = "Question <" + literal + "> is declared with different types.";
			break;
		
		case CONDITION:
			content = "Condition <" + literal + "> is not Bool type.";
			break;
			
		case OPERAND:
			content = "The type of operand <" + literal + "> is invalid to operator.";
			break;
			
		case CYCLIC:
			content = "<" + literal + "> and <" + literalOption + "> are cyclic dependent.";
			break;
		
		default:
			content = "Unknow error";
			break;
		}
		
		return "Error@line" + lineNumber + ": " + content; 
	}
	
}
