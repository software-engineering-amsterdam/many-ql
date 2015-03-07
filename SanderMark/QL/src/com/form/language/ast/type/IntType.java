package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;

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

	@Override
	public GenericValue<?> defaultValue() {
		// TODO Auto-generated method stub
		return new IntValue(0);
	}
	
	
}
