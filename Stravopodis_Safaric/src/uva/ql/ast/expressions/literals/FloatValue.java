package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;


public class FloatValue extends Value<Float>{	
	
	float value;
	public FloatValue(float _value, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	public Float getValue() {
		return this.value;
	}
	@Override
	public String toString(){
		return String.valueOf(this.getValue());
	}

}
