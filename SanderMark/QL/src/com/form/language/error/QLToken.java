package com.form.language.error;

public class QLToken {
    private int lineNumber;
    private int colNumber;
    
    public QLToken(int lineNumber, int colNumber) {
	super();
	this.lineNumber = lineNumber;
	this.colNumber = colNumber;
    }

    public int getLine(){
	return this.lineNumber;
    }
    
    public int getCharPositionInLine(){
	return this.colNumber;
    }
}