package org.uva.sea.ql.AST.value;

public class BooleanValue extends AbstractValue<Boolean> {

	private final boolean booleanValue;

	public BooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	@Override
	public Boolean getValue() {
		return booleanValue;
	}

	@Override
	public AbstractValue<Boolean> and(AbstractValue<Boolean> value) {
		return new BooleanValue(booleanValue && value.getValue());
	}

	@Override
	public AbstractValue<Boolean> or(AbstractValue<Boolean> value) {
		return new BooleanValue(booleanValue || value.getValue());
	}

	@Override
	public AbstractValue<Boolean> equal(AbstractValue<Boolean> value) {
		return new BooleanValue(booleanValue == value.getValue());
	}

	@Override
	public AbstractValue<Boolean> not() {
		return new BooleanValue(!booleanValue);
	}
}
