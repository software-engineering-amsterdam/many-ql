package uva.qls.ast.value;

public class StringValue extends GenericValue<String> {
	
	private String value;
	
	public StringValue(String _value){
		this.value=_value;
	}
	
	@Override
	public String getValue(){
		return this.value.replaceAll("[\"]", "");
	}
}
