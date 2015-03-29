package uva.sc.qls.logic;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;

public class ID implements IQLSNode {

	String	value;

	public ID(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return "[ID]: " + this.value;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
