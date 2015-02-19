package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;

public class BooleanValue extends Value<Boolean>{
	boolean value;
	
	public BooleanValue(boolean _value, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	public Boolean getValue() {
		return this.value;
	}
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
	
}
