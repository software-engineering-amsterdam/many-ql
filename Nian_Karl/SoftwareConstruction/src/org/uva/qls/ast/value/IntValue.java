package org.uva.qls.ast.value;

import org.uva.qls.ast.type.IntType;
import org.uva.qls.ast.type.Type;


public class IntValue extends Value{

	private final Integer value;
	
	public IntValue(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}
	
	@Override
	public Type getType() {
		return new IntType();
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
