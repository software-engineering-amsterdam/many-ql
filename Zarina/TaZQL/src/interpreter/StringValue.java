package interpreter;

public class StringValue extends Value {
	private final String stringValue;
	
	public StringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
	public String getStringValue() {
		return stringValue;
	}
	
	public boolean equals(Object object) {
		if (object instanceof StringValue) {
			return getStringValue().equals(((StringValue) object).getStringValue());
		}
		return false;
	}
}
