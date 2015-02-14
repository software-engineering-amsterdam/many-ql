package com.form.language.ast.values;

public class StringValue extends GenericValue<String> {
	private final String value;
	
	public StringValue(String value) {
		this.value = value;
	}
	public String evaluate() {
		return value;
	}

}
