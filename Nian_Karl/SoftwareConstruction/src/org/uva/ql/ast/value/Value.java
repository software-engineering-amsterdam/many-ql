
package org.uva.ql.ast.value;



public abstract class Value {
	
	private static final UndefinedValue UNDEFINED = new UndefinedValue(); 
	
	public abstract Object getValue();
	public abstract String toString();
	
	public boolean isUndefined(){return true;}
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
	
	public Value intPlus(IntValue arg) {return UNDEFINED;}
	public Value intMinus(IntValue arg) {return UNDEFINED;}
	public Value intMultiply(IntValue arg) {return UNDEFINED;}
	public Value intDivide(IntValue arg) {return UNDEFINED;}
	public Value boolAnd(BoolValue arg) {return UNDEFINED;}
	public Value boolOr(BoolValue arg) {return UNDEFINED;}
	public Value intGreater(IntValue arg) {return UNDEFINED;}
	public Value intGreaterEqual(IntValue arg) {return UNDEFINED;}
	public Value intLess(IntValue arg) {return UNDEFINED;}
	public Value intLessEqual(IntValue arg) {return UNDEFINED;}
	public Value boolEqual(BoolValue arg) {return UNDEFINED;}
	public Value boolNotEqual(BoolValue arg) {return UNDEFINED;}
	public Value intEqual(IntValue arg) {return UNDEFINED;}
	public Value intNotEqual(IntValue arg) {return UNDEFINED;}
	public Value strEqual(StrValue arg) {return UNDEFINED;}
	public Value strNotEqual(StrValue arg) {return UNDEFINED;}
	public Value StrPlus(StrValue arg) {return UNDEFINED;}
}
