package org.tax.datatypes;


public class QLBoolean extends QLType {
	boolean value;


	public QLBoolean(boolean value) {
		super();
		this.value = value;
	}
	
	public boolean getValue() { return value; }
	
	@Override
	public String toString() {
		return Boolean.valueOf(value).toString();
	}

}
