package com.form.language.ast.type;

public class IntType extends Type {

	@Override
	public Type getType() {
		return this;
	}
	
	@Override
	public Boolean isIntType(){
		return true;
	}

	@Override
	public String toString(){
		return "Int";
	}
}
