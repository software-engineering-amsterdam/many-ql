package com.form.language.issue;

public class QLToken {
    private int lineNumber;
    private int colNumber;
    
    public QLToken(int lineNumber, int colNumber) {
	super();
	this.lineNumber = lineNumber;
	this.colNumber = colNumber;
    }

    public int getLine(){
	return lineNumber;
    }
    
    public int getCharPositionInLine(){
	return colNumber;
    }
}