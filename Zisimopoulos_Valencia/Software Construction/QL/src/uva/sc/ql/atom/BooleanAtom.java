package uva.sc.ql.atom;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.logic.Expression;

public class BooleanAtom extends Expression {

	final String	value;

	public BooleanAtom(boolean value) {
		if (value) {
			this.value = "true";
		}
		else {
			this.value = "false";
		}
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return "[Boolean]: " + getValue();
	}

	public static BooleanAtom isTrue() {
		return new BooleanAtom(true);
	}

	public static BooleanAtom isFalse() {
		return new BooleanAtom(false);
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
