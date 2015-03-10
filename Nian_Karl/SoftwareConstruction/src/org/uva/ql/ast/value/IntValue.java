package org.uva.ql.ast.value;

public class IntValue extends Value {

	private final Integer value;

	public IntValue(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	/*
	 * ====================================================== Operations
	 * ======================================================
	 */
	@Override
	public Value positive() {
		return new IntValue(+getValue());
	}

	@Override
	public Value negative() {
		return new IntValue(-getValue());
	}

	/*------------------Double Dispatch ------------------*/
	@Override
	public Value plus(Value arg) {
		return arg.intPlus(this);
	}

	@Override
	public Value intPlus(IntValue arg) {
		return new IntValue(arg.getValue() + getValue());
	}

	@Override
	public Value minus(Value arg) {
		return arg.intMinus(this);
	}

	@Override
	public Value intMinus(IntValue arg) {
		return new IntValue(arg.getValue() - getValue());
	}

	@Override
	public Value multiply(Value arg) {
		return arg.intMultiply(this);
	}

	@Override
	public Value intMultiply(IntValue arg) {
		return new IntValue(arg.getValue() * getValue());
	}

	@Override
	public Value divide(Value arg) {
		return arg.intDivide(this);
	}

	@Override
	public Value intDivide(IntValue arg) {
		return new IntValue(arg.getValue() / getValue());
	}

	@Override
	public Value greater(Value arg) {
		return arg.intGreater(this);
	}

	@Override
	public Value intGreater(IntValue arg) {
		return new BoolValue(arg.getValue() > getValue());
	}

	@Override
	public Value greaterEqual(Value arg) {
		return arg.intGreaterEqual(this);
	}

	@Override
	public Value intGreaterEqual(IntValue arg) {
		return new BoolValue(arg.getValue() >= getValue());
	}

	@Override
	public Value less(Value arg) {
		return arg.intLess(this);
	}

	@Override
	public Value intLess(IntValue arg) {
		return new BoolValue(arg.getValue() < getValue());
	}

	@Override
	public Value lessEqual(Value arg) {
		return arg.intLessEqual(this);
	}

	@Override
	public Value intLessEqual(IntValue arg) {
		return new BoolValue(arg.getValue() <= getValue());
	}

	@Override
	public Value equal(Value arg) {
		return arg.intEqual(this);
	}

	@Override
	public Value intEqual(IntValue arg) {
		return new BoolValue(arg.getValue() == getValue());
	}

	@Override
	public Value notEqual(Value arg) {
		return arg.intNotEqual(this);
	}

	@Override
	public Value intNotEqual(IntValue arg) {
		return new BoolValue(arg.getValue() != getValue());
	}

	@Override
	public boolean isUndefined() {
		return false;
	}
}
