package org.uva.ql.ast.value;

public class Undefined extends Value {

	public Undefined() {
	}

	@Override
	public Undefined getValue() {
		return this;
	}

	@Override
	public String toString() {
		return "Undefined";
	}
}
