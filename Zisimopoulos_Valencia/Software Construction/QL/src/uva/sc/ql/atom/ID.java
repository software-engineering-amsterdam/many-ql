package uva.sc.ql.atom;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.logic.Expression;

public class ID extends Expression {

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

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
