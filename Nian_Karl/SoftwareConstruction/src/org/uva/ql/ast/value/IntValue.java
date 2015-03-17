package org.uva.ql.ast.value;


public class IntValue extends Value {

	private final Integer value;

	public IntValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IntValue){
			return value.equals(((IntValue) obj).value());
			
		} else {
			throw new UnsupportedOperationException("IntValue is only compariable with another IntValue.");
		}
	}
	
	@Override
	public boolean isDefined() {
		return true;
	}

	@Override
	public Integer value() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Value positive() {
		return new IntValue(+value());
	}

	@Override
	public Value negative() {
		return new IntValue(-value());
	}

	/*------------------Double Dispatch ------------------*/
	@Override
	public Value plus(Value arg) {
		return arg.intPlus(this);
	}

	@Override
	public Value intPlus(IntValue arg) {
		return new IntValue(arg.value() + value());
	}

	@Override
	public Value minus(Value arg) {
		return arg.intMinus(this);
	}

	@Override
	public Value intMinus(IntValue arg) {
		return new IntValue(arg.value() - value());
	}

	@Override
	public Value multiply(Value arg) {
		return arg.intMultiply(this);
	}

	@Override
	public Value intMultiply(IntValue arg) {
		return new IntValue(arg.value() * value());
	}

	@Override
	public Value divide(Value arg) {
		return arg.intDivide(this);
	}

	@Override
	public Value intDivide(IntValue arg) {
		return new IntValue(arg.value() / value());
	}

	@Override
	public Value greater(Value arg) {
		return arg.intGreater(this);
	}

	@Override
	public Value intGreater(IntValue arg) {
		return new BoolValue(arg.value() > value());
	}

	@Override
	public Value greaterEqual(Value arg) {
		return arg.intGreaterEqual(this);
	}

	@Override
	public Value intGreaterEqual(IntValue arg) {
		return new BoolValue(arg.value() >= value());
	}

	@Override
	public Value less(Value arg) {
		return arg.intLess(this);
	}

	@Override
	public Value intLess(IntValue arg) {
		return new BoolValue(arg.value() < value());
	}

	@Override
	public Value lessEqual(Value arg) {
		return arg.intLessEqual(this);
	}

	@Override
	public Value intLessEqual(IntValue arg) {
		return new BoolValue(arg.value() <= value());
	}

	@Override
	public Value equal(Value arg) {
		return arg.intEqual(this);
	}

	@Override
	public Value intEqual(IntValue arg) {
		return new BoolValue(arg.value() == value());
	}

	@Override
	public Value notEqual(Value arg) {
		return arg.intNotEqual(this);
	}

	@Override
	public Value intNotEqual(IntValue arg) {
		return new BoolValue(arg.value() != value());
	}

}
