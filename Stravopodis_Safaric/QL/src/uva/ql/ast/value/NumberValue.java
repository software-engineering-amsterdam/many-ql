package uva.ql.ast.value;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;

public class NumberValue extends GenericValue<Number>{

	private Number value;
	
	public NumberValue(Number _value){
		this.value = _value;
	}
	
	public static boolean isNumberValue(Expression expr){
		return (expr.evaluate().getClass() == NumberValue.class || expr.getClass().equals(Identifier.class));
	}
	
	public static NumberValue numberValueFromExpr(Expression expr){
		return new NumberValue(expr.evaluate().floatValue());
	}
	
	public NumberValue addition(NumberValue _value){
		return new NumberValue(this.value.floatValue() + _value.floatValue());
	}
	
	public NumberValue substraction(NumberValue _value){
		return new NumberValue(this.value.floatValue() - _value.floatValue());
	}
	
	public NumberValue exponentiation(NumberValue _value){
		return new NumberValue((float)Math.pow(this.value.floatValue(), _value.floatValue()));
	}
	
	public NumberValue multiplication(NumberValue _value){
		return new NumberValue(this.value.floatValue() * _value.floatValue());
	}
	
	public NumberValue division(NumberValue _value){
		return new NumberValue(this.value.floatValue() / _value.floatValue());
	}
	
	public BooleanValue greater(NumberValue _value){
		return new BooleanValue(this.value.floatValue() > _value.floatValue());
	}
	
	public BooleanValue greaterEqual(NumberValue _value){
		return new BooleanValue(this.value.floatValue() >= _value.floatValue());
	}
	
	public BooleanValue less(NumberValue _value){
		return new BooleanValue(this.value.floatValue() < _value.floatValue());
	}
	
	public BooleanValue lessEqual(NumberValue _value){
		return new BooleanValue(this.value.floatValue() <= _value.floatValue());
	}
	
	@Override
	public Number getValue(){
		return this.value;
	}
	
	@Override
	public float floatValue() {
		return this.value.floatValue();
	}

	@Override
	public int intValue() {
		return this.value.intValue();
	}
}
