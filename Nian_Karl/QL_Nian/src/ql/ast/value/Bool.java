package ql.ast.value;

public class Bool extends Value<Boolean> {
	private final Boolean value;
	
	public Bool(Boolean value){
		this.value = value;
	}
	
	@Override
	public Boolean getValue() {
		return this.value;
	}

}
