package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;


public class BooleanValue extends Value<Boolean> {
	boolean value;
	
	public BooleanValue(boolean _value){
		this.value = _value;
	}
	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
