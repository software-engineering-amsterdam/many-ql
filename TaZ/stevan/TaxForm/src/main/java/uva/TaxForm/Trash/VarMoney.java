package uva.TaxForm.Trash;

public class VarMoney {
	
	private String name;
	private float value;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = Float.parseFloat(value);
	}
}
