package ql.ast.value;

public class Str extends Value<String> {
	private final String value;
	
	public Str(String value){
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return this.value;
	}

}
