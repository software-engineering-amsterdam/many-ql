package uva.ql.ast.value;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.type.*;

public class NumberValue extends GenericValue<Integer>{

	private Integer value;
	
	public NumberValue(Integer _value){
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
		try{
			return new NumberValue(this.value / _value.value);
		}
		catch (ArithmeticException ex){
			System.out.println("Exception -> NumberValue -> " + ex.getMessage());
		}
		return new NumberValue(0);
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
	public List<Type> valueHasType() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
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
