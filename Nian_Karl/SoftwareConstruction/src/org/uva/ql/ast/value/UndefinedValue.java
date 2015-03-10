package org.uva.ql.ast.value;


public class UndefinedValue extends Value {

	public UndefinedValue() {
	}

	@Override
	public UndefinedValue getValue() {
		return this;
	}

	@Override
	public String toString() {
		return "Undefined";
	}

}
