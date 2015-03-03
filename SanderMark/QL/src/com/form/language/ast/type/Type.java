package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;

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
	
	public abstract GenericValue<?> defaultValue();
}
