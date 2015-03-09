package org.uva.ql.ast.value;

import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.Type;

public class Str extends Value {

	private final String value;

	public Str(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	// Equal
	@Override
	public Value equal(Value arg) {
		return arg.strEqual(this);
	}

	@Override
	public Value strEqual(Str arg) {
		return new Bool(arg.getValue() == getValue());
	}

	// Not Equal
	@Override
	public Value notEqual(Value arg) {
		return arg.strNotEqual(this);
	}

	@Override
	public Value strNotEqual(Str arg) {
		return new Bool(arg.getValue() != getValue());
	}

	@Override
	public Value plus(Value arg) {
		return arg.StrPlus(this);
	}
	
	public Value StrPlus(Str arg) {
		return new Str(arg.getValue() + getValue());
	}
	
	@Override
	public Type getType() {
		return new StrType();
	}
}
