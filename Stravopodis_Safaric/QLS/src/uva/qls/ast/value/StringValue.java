package uva.qls.ast.value;

public class StringValue extends GenericValue<String> {
	
	private String value;
	
	public StringValue(String _value){
		this.value=_value;
	}
	@Override
	public String getValue(){
		return this.value;
	}
	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
