package org.uva.sea.ql.encoders.ast;

/**
 * Represents an error of the TypeChecker
 */
public class TypeError {

	private final String name;
	private final String errorText;
	private final int line;
	private final int character;

	public TypeError(String name, String errorText, int line, int character) {
		this.name = name;
		this.errorText = errorText;
		this.line = line;
		this.character = character;
	}

	public String getName() {
		return name;
	}

	public String getTypeErrorText() {
		return errorText;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCharacter() {
		return character;
	}
}
