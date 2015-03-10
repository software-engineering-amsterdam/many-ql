package com.form.language.ast.type;

public class BoolType extends Type {

	@Override
	public Type getType() {
		return this;
	}
	
	@Override
	public Boolean isBoolType(){
		return true;
	}
	
	@Override
	public String toString(){
		return "Bool";
	}

/*	@Override
	public GenericValue<?> defaultValue() {
		// TODO Auto-generated method stub
		return new BoolValue(false);
	}*/

	
}