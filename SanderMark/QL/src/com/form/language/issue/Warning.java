package com.form.language.issue;

public class Warning extends Issue {

    public Warning(QLToken offendingToken, String message) {
	super(offendingToken, message);
    }
    
    @Override
    public String toString() {
	return "Warning: " + message + " Line: " + offendingToken.getLine() + ", Column: " + offendingToken.getCharPositionInLine();
    }
}
