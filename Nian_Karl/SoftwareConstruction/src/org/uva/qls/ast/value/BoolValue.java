package org.uva.qls.ast.value;

import org.uva.qls.ast.type.BoolType;
import org.uva.qls.ast.type.Type;


public class BoolValue extends Value{
	
	private final Boolean value;
	
	public BoolValue(Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public Type getType() {
		return new BoolType();
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
