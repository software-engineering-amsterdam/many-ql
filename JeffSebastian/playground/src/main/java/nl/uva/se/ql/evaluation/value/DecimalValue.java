package nl.uva.se.ql.evaluation.value;

import java.math.BigDecimal;

public class DecimalValue extends Value<BigDecimal> {

	public DecimalValue(BigDecimal value) {
		super(value);
	}

	@Override
	public Value add(Value value) {
		return value.addDecimal(this);
	}
	
	@Override
	public Value addInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).add(getValue()));
	}

	@Override
	public Value addDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.add(getValue()));
	}

	@Override
	public Value div(Value value) {
		return value.divDecimal(this);
	}
	
	@Override
	public Value divInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).divide(getValue()));
	}

	@Override
	public Value divDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.divide(getValue()));
	}

	@Override
	public Value mod(Value value) {
		return value.modDecimal(this);
	}
	
	@Override
	public Value modInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).remainder(getValue()));
	}

	@Override
	public Value modDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.remainder(getValue()));
	}

	@Override
	public Value mult(Value value) {
		return value.multDecimal(this);
	}
	
	@Override
	public Value multInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).multiply(getValue()));
	}

	@Override
	public Value multDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.multiply(getValue()));
	}

	@Override
	public Value neg() {
		return negDecimal();
	}
	
	@Override
	public Value negInteger() {
		return new DecimalValue(getValue().negate());
	}

	@Override
	public Value negDecimal() {
		return new DecimalValue(getValue().negate());
	}

	@Override
	public Value pos() {
		return posDecimal();
	}
	
	@Override
	public Value posInteger() {
		return new DecimalValue(getValue());
	}

	@Override
	public Value posDecimal() {
		return new DecimalValue(getValue());
	}

	@Override
	public Value pow(Value value) {
		return value.powDecimal(this);
	}
	
	@Override
	public Value powInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).pow(getValue().intValue()));
	}

	@Override
	public Value powDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.pow(getValue().intValue()));
	}

	@Override
	public Value sub(Value value) {
		return value.subDecimal(this);
	}
	
	@Override
	public Value subInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).subtract(getValue()));
	}

	@Override
	public Value subDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.subtract(getValue()));
	}

	@Override
	public Value equal(Value value) {
		return value.equalDecimal(this);
	}
	
	@Override
	public Value equalInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) == 0);
	}

	@Override
	public Value equalDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) == 0);
	}

	@Override
	public Value greaterOrEqual(Value value) {
		return value.greaterOrEqualDecimal(this);
	}
	
	@Override
	public Value greaterOrEqualInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) >= 0);
	}

	@Override
	public Value greaterOrEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) >= 0);
	}

	@Override
	public Value greaterThan(Value value) {
		return value.greaterThanDecimal(this);
	}
	
	@Override
	public Value greaterThanInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) > 0);
	}

	@Override
	public Value greaterThanDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) > 0);
	}

	@Override
	public Value lessOrEqual(Value value) {
		return value.lessOrEqualDecimal(this);
	}
	
	@Override
	public Value lessOrEqualInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) <= 0);
	}

	@Override
	public Value lessOrEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) <= 0);
	}

	@Override
	public Value lessThan(Value value) {
		return value.lessThanDecimal(this);
	}
	
	@Override
	public Value lessThanInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) < 0);
	}

	@Override
	public Value lessThanDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) < 0);
	}

	@Override
	public Value notEqual(Value value) {
		return value.notEqualDecimal(this);
	}
	
	@Override
	public Value notEqualInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) != 0);
	}

	@Override
	public Value notEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) != 0);
	}

}
