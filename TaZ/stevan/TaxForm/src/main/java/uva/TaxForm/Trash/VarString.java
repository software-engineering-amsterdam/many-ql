package uva.TaxForm.Trash;

import uva.TaxForm.AST.NodeVar.NodeVar;

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
