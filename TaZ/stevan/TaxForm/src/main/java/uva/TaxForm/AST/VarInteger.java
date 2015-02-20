package uva.TaxForm.AST;

public class VarInteger extends NodeVar {

	private int value;

	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = Integer.parseInt(value);
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
