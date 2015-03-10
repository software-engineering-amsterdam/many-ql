package uva.sc.qls.logic.style;

import uva.sc.qls.ast.INodeVisitor;

public class Color implements StyleProperty{

	String value;
	
	public Color(String value) {
		this.value = value;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String getValue() {
		return value;
	}
	
	public String toString() {
		String result = "[Color]: " + value;
		return result;
	}
	
	

}
