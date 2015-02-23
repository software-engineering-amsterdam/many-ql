package uva.ql.ast.value;

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
	public int toInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float toDecimal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
