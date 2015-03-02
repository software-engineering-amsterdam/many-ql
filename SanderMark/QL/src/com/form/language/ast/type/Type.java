package com.form.language.ast.type;

public abstract class Type {
	public abstract Type getType();
	
	public Boolean isBoolType(){
		return false;
	}
	
	public Boolean isErrorType(){
		return false;
	}
	
	public Boolean isStringType(){
		return false;
	}
	
	public Boolean isIntType(){
		return false;
	}
	
}
