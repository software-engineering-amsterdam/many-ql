package com.form.language.error;

import org.antlr.v4.runtime.Token;

public class QLToken {
    private int lineNumber;
    private int colNumber;
    
    public QLToken(Token tokenInfo){
	this.lineNumber = tokenInfo.getLine();
	this.colNumber = tokenInfo.getCharPositionInLine();
    }
  
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