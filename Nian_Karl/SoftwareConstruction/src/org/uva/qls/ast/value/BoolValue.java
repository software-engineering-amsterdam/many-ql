package org.uva.qls.ast.value;


public class BoolValue extends Value  {

	private final Boolean value;

	public BoolValue(Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean value() {
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
