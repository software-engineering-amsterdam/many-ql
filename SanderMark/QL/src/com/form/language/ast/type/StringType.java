package com.form.language.ast.type;

public class StringType extends Type {

	@Override
	public Type getType() {
		return this;
	}

	@Override
	public Boolean isStringType(){
		return true;
	}

}
