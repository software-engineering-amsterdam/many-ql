package com.form.language.ast.values;

public class IntValue extends GenericValue<Integer>{
	private final int value;
	
	public IntValue(int value) {
		this.value = value;
	}
	public int evaluate() {
		return value;
	} 
	
	//Math
	public IntValue Negation()
	{
		return new IntValue(-value);
	}	
	public IntValue Addition(IntValue right){
		return new IntValue(value + right.evaluate());
	}	
	public IntValue Division(IntValue right){
		return new IntValue(value / right.evaluate());		
	}
	public IntValue Modulus(IntValue right){
		return new IntValue(value % right.evaluate());
	}
	public IntValue Multiplication(IntValue right){
		return new IntValue(value * right.evaluate());
	}
	public IntValue Substraction(IntValue right){
		return new IntValue(value - right.evaluate());
	}
	
	//Logic	
	public BoolValue LessThan(IntValue right){
		return new BoolValue(value < right.value);
	}	
	public BoolValue LessThanOrEqual(IntValue right){
		return new BoolValue(value <= right.value);
	}	
	public BoolValue GreaterThan(IntValue right){
		return new BoolValue(value > right.value);
	}	
	public BoolValue GreaterThanOrEqual(IntValue right){
		return new BoolValue(value >= right.value);
	}	
	public BoolValue Equal(IntValue right){
		return new BoolValue(value == right.value);
	}	
	public BoolValue NotEqual(IntValue right){
		return new BoolValue(value != right.value);
	}

	
	@Override
	public String toString(){
		return new Integer(value).toString();
		
	}

}
