package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;

public class IntValue extends Value<Integer>{
	
	private Integer value;
	
	public IntValue(Integer _value, Tuple<Integer, Integer> _codeLines) {
		super(_codeLines);
		this.value = _value;
	}
	 
	public Integer getValue(){
		return this.value;
	}
	@Override
	public String toString(){
		return String.valueOf(this.getValue());
	}
	
}
