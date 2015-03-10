package uva.sc.qls.logic.style;

import uva.sc.qls.ast.INodeVisitor;

public class Width implements StyleProperty{

	Integer value;
	
	public Width(Integer value) {
		this.value = value;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Integer getValue() {
		return value;
	}
	
	public String toString() {
		String result = "[FontSize]: " + value;
		return result;
	}

}
