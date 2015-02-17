package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;


public class CurrencyValue extends Value<Float>{
	float value;
	
	public CurrencyValue(float _value, Tuple<Integer, Integer> _codeLines) {
		super(_codeLines);
		this.value = (float)Math.round(_value * 10000) / 10000;	// 4 digits - decimals
	}
	public String toString(){
		return String.valueOf(this.getValue());
	}
	public Float getValue(){
		return this.value;
	}

}
