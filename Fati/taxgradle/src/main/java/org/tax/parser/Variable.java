package org.tax.parser;

public class Variable {
	String name;
	String value;
	String type;

	public Variable(String name, String value, String type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.name +  " : " + this.value + " of type " + this.type; 
	}
	
}
