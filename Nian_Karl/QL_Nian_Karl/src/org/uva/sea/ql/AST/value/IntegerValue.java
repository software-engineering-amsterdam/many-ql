package org.uva.sea.ql.AST.value;

public class IntegerValue extends AbstractValue<Integer> {

	private final int intValue;

	public IntegerValue(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer getValue() {
		return intValue;
	}
	
	@Override
	public AbstractValue<Integer> add(AbstractValue<Integer> value) {
		return new IntegerValue(intValue + value.getValue());
	}

	@Override
	public AbstractValue<Integer> minus(AbstractValue<Integer> value) {
		return new IntegerValue(intValue - value.getValue());
	}

	@Override
	public AbstractValue<Integer> divide(AbstractValue<Integer> value) {
		return new IntegerValue(intValue / value.getValue());
	}

	@Override
	public AbstractValue<Integer> multiply(AbstractValue<Integer> value) {
		return new IntegerValue(intValue * value.getValue());
	}

}