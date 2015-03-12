package org.uva.qls.ast.value;

public class StrValue extends Value {

	private final String value;

	public StrValue(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean isDefined() {
		if (!value.equals("") || value != null) {
			return true;
		}
		return false;
	}

}
