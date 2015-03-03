package uva.ql.ast.value;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;

public class NumberValue extends GenericValue<Integer>{

	private int value;
	
	public NumberValue(int _value){
		this.value = _value;
	}
	
	public static boolean isNumberValue(Expression expr){
		return (expr.evaluate().getClass() == NumberValue.class || expr.getClass().equals(Identifier.class));
	}
	
	public static NumberValue numberValueFromExpr(Expression expr){
		return new NumberValue(expr.evaluate().intValue());
	}
	
	public NumberValue addition(NumberValue _value){
		return new NumberValue(this.value + _value.intValue());
	}
	
	public NumberValue substraction(NumberValue _value){
		return new NumberValue(this.value- _value.value);
	}
	
	public NumberValue exponentiation(NumberValue _value){
		return new NumberValue((int)Math.pow(this.value, _value.value));
	}
	
	public NumberValue multiplication(NumberValue _value){
		return new NumberValue(this.value * _value.value);
	}
	
	public NumberValue division(NumberValue _value){
		return new NumberValue(this.value / _value.value);
	}
	
	public BooleanValue greater(NumberValue _value){
		return new BooleanValue(this.value > _value.value);
	}
	
	public BooleanValue greaterEqual(NumberValue _value){
		return new BooleanValue(this.value >= _value.value);
	}
	
	public BooleanValue less(NumberValue _value){
		return new BooleanValue(this.value < _value.value);
	}
	
	public BooleanValue lessEqual(NumberValue _value){
		return new BooleanValue(this.value <= _value.value);
	}
	
	@Override
	public Integer getValue(){
		return this.value;
	}

	@Override
	public int intValue() {
		return this.value;
	}
}
