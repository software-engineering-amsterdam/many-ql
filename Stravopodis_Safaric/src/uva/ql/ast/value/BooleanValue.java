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
	
	public static BooleanValue booleanValueFromExpr(Expression expr){
		return new BooleanValue((boolean)expr.evaluate().getValue());
	}
	
	public static boolean isBooleanValue(Expression expr){
		return expr.evaluate().getClass() == BooleanValue.class;
	}
	
	public BooleanValue and(BooleanValue value){
		return new BooleanValue(this.value && value.value);
	}
	public BooleanValue or(BooleanValue value){
		return new BooleanValue(this.value && value.value);
	}

	@Override
	public float floatValue() {return 0;}
	@Override
	public int intValue() {return 0;}
}
