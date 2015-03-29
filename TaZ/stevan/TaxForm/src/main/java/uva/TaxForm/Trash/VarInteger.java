package uva.TaxForm.Trash;

import uva.TaxForm.AST.NodeVar.NodeVar;

public class VarInteger extends NodeVar {
	
	private String name;
	private int value;

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
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
}
