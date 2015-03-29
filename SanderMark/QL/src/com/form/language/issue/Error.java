package com.form.language.issue;

public class Error extends Issue{

    public Error(QLToken offendingToken, String message) {
	super(offendingToken, message);
    }

    @Override
    public String toString() {
	return "Error: " + message + " Line: " + offendingToken.getLine() + ", Column: " + offendingToken.getCharPositionInLine();
    }
}
