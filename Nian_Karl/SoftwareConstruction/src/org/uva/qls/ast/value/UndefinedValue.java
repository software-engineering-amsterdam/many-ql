package org.uva.qls.ast.value;

import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.type.UndefinedType;

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

	@Override
	public Type getType() {
		return new UndefinedType();
	}
}
