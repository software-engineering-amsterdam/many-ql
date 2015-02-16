package com.form.language.ast.values;

public class IntValue extends GenericValue<Integer>{
	private final int value;
	
	public IntValue(int value) {
		this.value = value;
	}
	public int evaluate() {
		return value;
	}
	
	public IntValue Add(IntValue addition){
		return new IntValue(value + addition.evaluate());
	}
	
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
