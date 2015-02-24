package com.form.language.ast.type;

public class IdType extends Type {
	@Override
	public Type getType() {
		return this;
	}
	
	@Override
	public Boolean isErrorType(){
		return true;
	}
}

