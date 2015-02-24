package com.form.language.error;
import org.antlr.v4.runtime.Token;

public class Error {
	private Token offendingToken;
	private String message;
	
	public Error(Token offendingToken, String message){
		this.offendingToken = offendingToken;
	}
	
	@Override
	public String toString(){
		return message + " Line: " + offendingToken.getLine() + ", Column: " + offendingToken.getCharPositionInLine();
	}
}
