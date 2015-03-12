package org.uva.util.message;

public abstract class Message {
	
	protected final int lineNumber;
	protected final String literal;
	
	public Message(int lineNumber, String literal) {
		this.lineNumber = lineNumber;
		this.literal = literal;
	}
	
	public int getLineNumber(){
		return lineNumber;
	}
	
	public String getLiteral(){
		return literal;
	}
	
	public abstract String toString();

}
