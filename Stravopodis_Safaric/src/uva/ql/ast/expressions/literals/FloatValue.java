package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;

public class FloatValue extends Value<Float>{	
	
	float value;
	public FloatValue(float _value){
		this.value = _value;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.getValue());
	}

	@Override
	public Float getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}
}
