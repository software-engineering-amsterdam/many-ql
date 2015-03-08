package nl.uva.se.interpreter.value;

import java.math.BigDecimal;

public class DecimalValue extends Value<BigDecimal> {

	public DecimalValue(BigDecimal value) {
		super(value);
	}

	@Override
	public Value add(Value value) {
		return new DecimalValue(getValue().add(getDecimal(value)));
	}

	@Override
	public Value div(Value value) {
		return new DecimalValue(getValue().divide(getDecimal(value)));
	}

	@Override
	public Value mod(Value value) {
		return new DecimalValue(getValue().remainder(getDecimal(value)));
	}

	@Override
	public Value mult(Value value) {
		return new DecimalValue(getValue().multiply(getDecimal(value)));
	}

	@Override
	public Value neg() {
		return new DecimalValue(getValue().negate());
	}

	@Override
	public Value pos() {
		return new DecimalValue(getValue());
	}

	@Override
	public Value pow(Value value) {
		return new DecimalValue(getValue().pow(getDecimal(value).intValue()));
	}

	@Override
	public Value sub(Value value) {
		return new DecimalValue(getValue().subtract(getDecimal(value)));
	}

	@Override
	public Value equal(Value value) {
		return new BooleanValue(getValue().compareTo(getDecimal(value)) == 0);
	}

	@Override
	public Value greaterOrEqual(Value value) {
		return new BooleanValue(getValue().compareTo(getDecimal(value)) >= 0);
	}

	@Override
	public Value greaterThen(Value value) {
		return new BooleanValue(getValue().compareTo(getDecimal(value)) > 0);
	}

	@Override
	public Value lessOrEqual(Value value) {
		return new BooleanValue(getValue().compareTo(getDecimal(value)) <= 0);
	}

	@Override
	public Value lessThen(Value value) {
		return new BooleanValue(getValue().compareTo(getDecimal(value)) < 0);
	}

	@Override
	public Value notEqual(Value value) {
		return new BooleanValue(getValue().compareTo(getDecimal(value)) != 0);
	}

	private BigDecimal getDecimal(Value value) {
		DecimalValue decVal = (DecimalValue) value;
		return decVal.getValue();
	}

}
