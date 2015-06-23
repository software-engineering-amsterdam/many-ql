package uva.TaxForm.Trash;

import uva.TaxForm.AST.NodeVar.NodeVar;

public class VarBoolean extends NodeVar {

	private String name;
	private boolean value;

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
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
}
