package org.uva.ql.ast.value;

import org.uva.ql.ast.type.Type;


public abstract class Value {
	
	private static final Undefined UNDEFINED = new Undefined(); 
	
	public abstract Object getValue();
	public abstract String toString();

	public Value not() {return UNDEFINED;}
	public Value positive() {return UNDEFINED;}
	public Value negative() {return UNDEFINED;}
	
	public Value plus(Value arg) {return UNDEFINED;}
	public Value minus(Value arg) {return UNDEFINED;}
	public Value multiply(Value arg) {return UNDEFINED;}
	public Value divide(Value arg) {return UNDEFINED;}
	public Value and(Value arg) {return UNDEFINED;}
	public Value or(Value arg) {return UNDEFINED;}
	public Value equal(Value arg) {return UNDEFINED;}
	public Value notEqual(Value arg) {return UNDEFINED;}
	public Value greater(Value arg) {return UNDEFINED;}
	public Value greaterEqual(Value arg) {return UNDEFINED;}
	public Value less(Value arg) {return UNDEFINED;}
	public Value lessEqual(Value arg) {return UNDEFINED;}
	
	public Value intPlus(Int arg) {return UNDEFINED;}
	public Value intMinus(Int arg) {return UNDEFINED;}
	public Value intMultiply(Int arg) {return UNDEFINED;}
	public Value intDivide(Int arg) {return UNDEFINED;}
	public Value boolAnd(Bool arg) {return UNDEFINED;}
	public Value boolOr(Bool arg) {return UNDEFINED;}
	public Value intGreater(Int arg) {return UNDEFINED;}
	public Value intGreaterEqual(Int arg) {return UNDEFINED;}
	public Value intLess(Int arg) {return UNDEFINED;}
	public Value intLessEqual(Int arg) {return UNDEFINED;}
	public Value boolEqual(Bool arg) {return UNDEFINED;}
	public Value boolNotEqual(Bool arg) {return UNDEFINED;}
	public Value intEqual(Int arg) {return UNDEFINED;}
	public Value intNotEqual(Int arg) {return UNDEFINED;}
	public Value strEqual(Str arg) {return UNDEFINED;}
	public Value strNotEqual(Str arg) {return UNDEFINED;}
	public Value StrPlus(Str arg) {return UNDEFINED;}
	public abstract Type getType();
}
