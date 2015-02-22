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

}
