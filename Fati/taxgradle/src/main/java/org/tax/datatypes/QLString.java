package org.tax.datatypes;

public class QLString extends QLType {
	String value;

	public QLString(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	

}
