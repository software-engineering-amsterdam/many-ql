package evaluator;

public class StringValue extends Value<String> {
	//private final String stringValue;
	
	public StringValue(String stringValue) {
		super(stringValue);
		//this.stringValue = stringValue;
	}
	
	
	/*
	public boolean equals(Object object) {
		if (object instanceof Value) {
			return getValue().equals(((Value) object).getValue());
		}
		return false;
	} */
}
