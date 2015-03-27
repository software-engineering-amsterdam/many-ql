package com.form.language.issue;

public class Error {
    private QLToken offendingToken;
    private String message;

    public Error(QLToken offendingToken, String message) {
	this.offendingToken = offendingToken;
	this.message = message;
    }

    @Override
    public String toString() {
	return message + " Line: " + offendingToken.getLine() + ", Column: " + offendingToken.getCharPositionInLine();
    }
}
