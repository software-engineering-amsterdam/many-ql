package uva.ql.ast.value;

import uva.ql.ast.type.TypeString;

public class StringValue extends GenericValue<String> {

	private String value;
	
	public StringValue(String _value){
		this.value = _value;	
	}
	
	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public TypeString valueHasType() {
		return new TypeString();
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
		return this.value;
	}
}
