package uva.ql.ast.value;

import uva.ql.ast.type.TypeInteger;

public class NumberValue extends GenericValue<Integer>{

	private int value;
	
	public NumberValue(int _value){
		this.value = _value;
	}
	
	public NumberValue addition(NumberValue _value){
		return new NumberValue(this.value + _value.value);
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
		assert _value.value == 0;
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
	public TypeInteger valueHasType() {
		return new TypeInteger();
	}
	
	@Override
	public boolean equalsTo(GenericValue<?> value) {
		if (value == null){
			return false;
		}
		return value.getValue() == this.getValue();
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.value);
	}
}
