package uva.ql.ast.value;

import uva.ql.ast.expressions.Expression;

public class BooleanValue extends GenericValue<Boolean> {

	private boolean value;
	
	public BooleanValue(boolean _value){
		this.value = _value;
	}
	
	@Override
	public Boolean getValue() {
		return this.value;
	}
	public static boolean isBooleanValue(Expression expr){
		return expr.evaluate().getClass() == BooleanValue.class;
	}

	@Override
	public int toInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float toDecimal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
