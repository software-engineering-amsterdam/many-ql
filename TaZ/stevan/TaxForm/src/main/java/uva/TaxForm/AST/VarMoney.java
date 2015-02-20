package uva.TaxForm.AST;

public class VarMoney extends NodeVar {

	private float value;
	
	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = Float.parseFloat(value);
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
