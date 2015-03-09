package org.uva.ql.ast.value;


public class Int extends Value{

	private final Integer value;
	
	public Int(Integer value) {
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

	
/*======================================================
	Operations
======================================================*/
//Positive
	@Override
	public Value positive() {
		return new Int(+getValue());
	}

//Negative
	@Override
	public Value negative() {
		return new Int(-getValue());
	}
	
/*------------------Double Dispatch ------------------*/
//Plus
	@Override
	public Value plus(Value arg) {
		return arg.intPlus(this);
	}
	
	@Override
	public Value intPlus(Int arg) {
		return new Int(arg.getValue() + getValue());
	}

//Minus
	@Override
	public Value minus(Value arg) {
		return arg.intMinus(this);
	}
	
	@Override
	public Value intMinus(Int arg) {
		return new Int(arg.getValue() - getValue());
	}

//Multiply
	@Override
	public Value multiply(Value arg) {
		return arg.intMultiply(this);
	}
	
	@Override
	public Value intMultiply(Int arg) {
		return new Int(arg.getValue() * getValue());
	}

//Divide
	@Override
	public Value divide(Value arg) {
		return arg.intDivide(this);
	}
	
	@Override
	public Value intDivide(Int arg) {
		return new Int(arg.getValue() / getValue());
	}

//Greater
	@Override
	public Value greater(Value arg) {
		return arg.intGreater(this);
	}
	
	@Override
	public Value intGreater(Int arg) {
		return new Bool(arg.getValue() > getValue());
	}

//Greater Equal
	@Override
	public Value greaterEqual(Value arg) {
		return arg.intGreaterEqual(this);
	}
	
	@Override
	public Value intGreaterEqual(Int arg) {
		return new Bool(arg.getValue() >= getValue());
	}
	
//Less
	@Override
	public Value less(Value arg) {
		return arg.intLess(this);
	}
	
	@Override
	public Value intLess(Int arg) {
		return new Bool(arg.getValue() < getValue());
	}
	
	//Less Equal
	@Override
	public Value lessEqual(Value arg) {
		return arg.intLessEqual(this);
	}
	
	@Override
	public Value intLessEqual(Int arg) {
		return new Bool(arg.getValue() <= getValue());
	}
	
//Equal
	@Override
	public Value equal(Value arg) {
		return arg.intEqual(this);
	}
	
	@Override
	public Value intEqual(Int arg) {
		return new Bool(arg.getValue() == getValue());
	}
	
//Not Equal
	@Override
	public Value notEqual(Value arg) {
		return arg.intNotEqual(this);
	}
	
	@Override
	public Value intNotEqual(Int arg) {
		return new Bool(arg.getValue() != getValue());
	}

}
