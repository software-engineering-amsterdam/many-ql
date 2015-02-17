package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;

public class IntValue extends Value<Integer>{
	private Integer value;
	
	public IntValue(Integer _value){
		this.value = _value;
	}
	@Override 
	public Integer getValue(){
		return this.value;
	}
	@Override
	public String toString(){
		return String.valueOf(this.getValue());
	}
	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
