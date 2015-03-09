package org.uva.ql.ast.value;

import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.type.UndefinedType;

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

	@Override
	public Type getType() {
		return new UndefinedType();
	}
}
