package ql.ast.value;

public class Int extends Value<Integer> {
	private final Integer value;
	
	public Int(Integer value){
		this.value = value;
	}
	
	@Override
	public Integer getValue() {
		return this.value;
	}
	
	public Int add(Int number){
		return new Int(value + number.getValue());
	}

}
