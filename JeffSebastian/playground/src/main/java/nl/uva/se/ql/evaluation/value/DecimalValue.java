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
	public DecimalValue addInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).add(getValue()));
	}

	@Override
	public DecimalValue addDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.add(getValue()));
	}

	@Override
	public Value div(Value value) {
		return value.divDecimal(this);
	}
	
	@Override
	public DecimalValue divInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).divide(getValue()));
	}

	@Override
	public DecimalValue divDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.divide(getValue()));
	}

	@Override
	public Value mod(Value value) {
		return value.modDecimal(this);
	}
	
	@Override
	public DecimalValue modInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).remainder(getValue()));
	}

	@Override
	public DecimalValue modDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.remainder(getValue()));
	}

	@Override
	public Value mult(Value value) {
		return value.multDecimal(this);
	}
	
	@Override
	public DecimalValue multInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).multiply(getValue()));
	}

	@Override
	public DecimalValue multDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.multiply(getValue()));
	}

	@Override
	public Value neg() {
		return negDecimal();
	}
	
	@Override
	public DecimalValue negInteger() {
		return new DecimalValue(getValue().negate());
	}

	@Override
	public DecimalValue negDecimal() {
		return new DecimalValue(getValue().negate());
	}

	@Override
	public Value pos() {
		return posDecimal();
	}
	
	@Override
	public DecimalValue posInteger() {
		return new DecimalValue(getValue());
	}

	@Override
	public DecimalValue posDecimal() {
		return new DecimalValue(getValue());
	}

	@Override
	public Value pow(Value value) {
		return value.powDecimal(this);
	}
	
	@Override
	public DecimalValue powInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).pow(getValue().intValue()));
	}

	@Override
	public DecimalValue powDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.pow(getValue().intValue()));
	}

	@Override
	public Value sub(Value value) {
		return value.subDecimal(this);
	}
	
	@Override
	public DecimalValue subInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new DecimalValue(new BigDecimal(i).subtract(getValue()));
	}

	@Override
	public DecimalValue subDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.subtract(getValue()));
	}

	@Override
	public Value equal(Value value) {
		return value.equalDecimal(this);
	}
	
	@Override
	public BooleanValue equalInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) == 0);
	}

	@Override
	public BooleanValue equalDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) == 0);
	}

	@Override
	public Value greaterOrEqual(Value value) {
		return value.greaterOrEqualDecimal(this);
	}
	
	@Override
	public BooleanValue greaterOrEqualInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) >= 0);
	}

	@Override
	public BooleanValue greaterOrEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) >= 0);
	}

	@Override
	public Value greaterThan(Value value) {
		return value.greaterThanDecimal(this);
	}
	
	@Override
	public BooleanValue greaterThanInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) > 0);
	}

	@Override
	public BooleanValue greaterThanDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) > 0);
	}

	@Override
	public Value lessOrEqual(Value value) {
		return value.lessOrEqualDecimal(this);
	}
	
	@Override
	public BooleanValue lessOrEqualInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) <= 0);
	}

	@Override
	public BooleanValue lessOrEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) <= 0);
	}

	@Override
	public Value lessThan(Value value) {
		return value.lessThanDecimal(this);
	}
	
	@Override
	public BooleanValue lessThanInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) < 0);
	}

	@Override
	public BooleanValue lessThanDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) < 0);
	}

	@Override
	public Value notEqual(Value value) {
		return value.notEqualDecimal(this);
	}
	
	@Override
	public BooleanValue notEqualInteger(IntegerValue value) {
		Integer i = value.getValue();
		return new BooleanValue(new BigDecimal(i).compareTo(getValue()) != 0);
	}

	@Override
	public BooleanValue notEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(getValue()) != 0);
	}

}
