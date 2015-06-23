package qlProject.ast.value;

import qlProject.ast.type.StringType;
import qlProject.ast.type.Type;

public class StringValue extends Value {

	private final String str;

	public StringValue(String str){
	this.str = str;
	}
	

	@Override
	public String getValue() {
		return str;
	}

	@Override
	public boolean equals(Value value) {
		return value instanceof StringValue;
	}

	@Override
	public boolean isOfType(StringType type){
		return true;
	}
	
	@Override
	public boolean isOfType(Type type){
		return this.isOfType(type);
	}

	@Override
	public Type getType() {
		return new StringType();
	}

}