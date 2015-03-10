package org.uva.qls.ast.value;

import org.uva.qls.ast.type.StrType;
import org.uva.qls.ast.type.Type;

public class StrValue extends Value {

	private final String value;

	public StrValue(String value) {
		this.value = value;
	}

	@Override
	public String getValue(Evaluator e) {
		return value;
	}

	@Override
	public Type getType() {
		return new StrType();
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
