package uva.sc.qls.logic.style;

import uva.sc.qls.ast.IQLSNodeVisitor;

public class Width implements StyleProperty {

	Integer	value;

	public Width(Integer value) {
		this.value = value;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
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
