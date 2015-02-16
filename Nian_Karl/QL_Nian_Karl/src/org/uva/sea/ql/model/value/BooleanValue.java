package org.uva.sea.ql.model.value;

public class BooleanValue extends AbstractValue<Boolean> {

	private final boolean booleanValue;

	public BooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
	
	@Override
	public Boolean getValue() {
		return booleanValue;
	}
}
