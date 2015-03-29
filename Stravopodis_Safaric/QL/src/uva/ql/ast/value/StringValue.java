package uva.ql.ast.value;

import java.util.Arrays;
import java.util.List;
import uva.ql.ast.type.Type;
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
	public List<Type> valueHasType() {
		return Arrays.asList(new TypeString());
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
