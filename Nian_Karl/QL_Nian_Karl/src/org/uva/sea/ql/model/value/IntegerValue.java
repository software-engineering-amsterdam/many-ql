package org.uva.sea.ql.model.value;

public class IntegerValue extends AbstractValue<Integer> {

	private final int intValue;

	public IntegerValue(int intValue) {
		this.intValue = intValue;
	}
	
	@Override
	public Integer getValue() {
		return intValue;
	}
}