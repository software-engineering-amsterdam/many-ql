package uva.TaxForm.AST.NodeVar;

public class VarString extends NodeVar{

	private String name;
	private String value;

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
