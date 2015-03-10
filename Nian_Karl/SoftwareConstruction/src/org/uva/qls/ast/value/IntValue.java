package org.uva.qls.ast.value;

public class IntValue extends Value {

	private final Integer value;

	public IntValue(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public boolean isDefined() {
		return true;
	}
	
}
