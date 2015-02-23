package uva.ql.ast.value;

import uva.ql.ast.expressions.Expression;

public class NumberValue extends GenericValue<Number>{

	private Number value;
	
	public NumberValue(Number _value){
		this.value = _value;
	}
	
	@Override
	public Number getValue(){
		return this.value;
	}
	public static boolean isNumberValue(Expression expr){
		return expr.evaluate().getClass() == NumberValue.class;
	}

	@Override
	public int toInt() {
		return (int)this.value.intValue();
	}

	@Override
	public float toDecimal() {
		return (float)this.value.floatValue();
	}
}
