package uva.TaxForm.AST;

public class VarBoolean extends NodeVar {

	private boolean value;

	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}
	
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = Boolean.parseBoolean(value);
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
