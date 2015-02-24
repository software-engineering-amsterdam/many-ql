package com.form.language.ast.type;

public class ErrorType extends Type {

	@Override
	public Type getType() {
		return this;
	}
	
	@Override
	public Boolean isErrorType(){
		return true;
	}
	
	@Override
	public String toString(){
		return "Error";
	}

}
