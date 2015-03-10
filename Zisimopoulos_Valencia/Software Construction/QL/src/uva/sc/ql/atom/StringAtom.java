package uva.sc.ql.atom;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.logic.Expression;

public class StringAtom extends Expression {

	String	value;

	public StringAtom(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
