package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;

public class CurrencyValue extends Value<Float>{
	float value;
	
	public CurrencyValue(float _value) {
		this.value = (float)Math.round(_value * 10000) / 10000;	// 4 digits - decimals
	}

	@Override
	public String toString(){
		return String.valueOf(this.getValue());
	}
	public Float getValue(){
		return this.value;
	}

	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}
}
