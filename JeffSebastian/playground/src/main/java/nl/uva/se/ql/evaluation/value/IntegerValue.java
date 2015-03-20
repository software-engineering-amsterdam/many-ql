package nl.uva.se.ql.evaluation.value;

import java.math.BigDecimal;

public class IntegerValue extends Value<Integer> {

	public IntegerValue(int value) {
		super(value);
	}

	@Override
	public Value add(Value value) {
		return value.addInteger(this);
	}
	
	@Override
	public Value addInteger(IntegerValue value) {
		return new IntegerValue(value.getValue() + getValue());
	}

	@Override
	public Value addDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.add(new BigDecimal(getValue())));
	}

	@Override
	public Value div(Value value) {
		return value.divInteger(this);
	}
	
	@Override
	public Value divInteger(IntegerValue value) {
		return new IntegerValue(value.getValue() / getValue());
	}

	@Override
	public Value divDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.divide(new BigDecimal(getValue())));
	}

	@Override
	public Value mod(Value value) {
		return value.modInteger(this);
	}
	
	@Override
	public Value modInteger(IntegerValue value) {
		return new IntegerValue(value.getValue() % getValue());
	}

	@Override
	public Value modDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.remainder(new BigDecimal(getValue())));
	}

	@Override
	public Value mult(Value value) {
		return value.multInteger(this);
	}
	
	@Override
	public Value multInteger(IntegerValue value) {
		return new IntegerValue(value.getValue() * getValue());
	}

	@Override
	public Value multDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.multiply(new BigDecimal(getValue())));
	}

	@Override
	public Value neg() {
		return negInteger();
	}
	
	@Override
	public Value negInteger() {
		return new IntegerValue(-getValue());
	}

	@Override
	public Value negDecimal() {
		return new DecimalValue(new BigDecimal(-getValue()));
	}

	@Override
	public Value pos() {
		return posInteger();
	}

	@Override
	public Value posInteger() {
		return new IntegerValue(getValue());
	}

	@Override
	public Value posDecimal() {
		return new DecimalValue(new BigDecimal(getValue()));
	}

	@Override
	public Value pow(Value value) {
		return value.powInteger(this);
	}
	
	@Override
	public Value powInteger(IntegerValue value) {
		return new IntegerValue(value.getValue() ^ getValue());
	}

	@Override
	public Value powDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.pow(getValue()));
	}

	@Override
	public Value sub(Value value) {
		return value.subInteger(this);
	}
	
	@Override
	public Value subInteger(IntegerValue value) {
		return new IntegerValue(value.getValue() - getValue());
	}

	@Override
	public Value subDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new DecimalValue(d.subtract(new BigDecimal(getValue())));
	}

	@Override
	public Value equal(Value value) {
		return value.equalInteger(this);
	}
	
	@Override
	public Value equalInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() == getValue());
	}

	@Override
	public Value equalDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(new BigDecimal(getValue())) == 0);
	}

	@Override
	public Value greaterOrEqual(Value value) {
		return value.greaterOrEqualInteger(this);
	}
	
	@Override
	public Value greaterOrEqualInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() >= getValue());
	}

	@Override
	public Value greaterOrEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(new BigDecimal(getValue())) >= 0);
	}

	@Override
	public Value greaterThan(Value value) {
		return value.greaterThanInteger(this);
	}
	
	@Override
	public Value greaterThanInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() > getValue());
	}

	@Override
	public Value greaterThanDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(new BigDecimal(getValue())) > 0);
	}

	@Override
	public Value lessOrEqual(Value value) {
		return value.lessOrEqualInteger(this);
	}
	
	@Override
	public Value lessOrEqualInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() <= getValue());
	}

	@Override
	public Value lessOrEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(new BigDecimal(getValue())) <= 0);
	}

	@Override
	public Value lessThan(Value value) {
		return value.lessOrEqualInteger(this);
	}
	
	@Override
	public Value lessThanInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() < getValue());
	}

	@Override
	public Value lessThanDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(new BigDecimal(getValue())) < 0);
	}

	@Override
	public Value notEqual(Value value) {
		return value.notEqualInteger(this);
	}
	
	@Override
	public Value notEqualInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() != getValue());
	}

	@Override
	public Value notEqualDecimal(DecimalValue value) {
		BigDecimal d = value.getValue();
		return new BooleanValue(d.compareTo(new BigDecimal(getValue())) != 0);
	}

	@Override
	public Value promote() {
		return new DecimalValue(new BigDecimal(getValue()));
	}
	
}
