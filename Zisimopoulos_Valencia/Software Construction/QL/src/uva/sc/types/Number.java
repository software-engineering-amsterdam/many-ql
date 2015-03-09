package uva.sc.types;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.NumberAtom;
import uva.sc.logic.Expression;

public class Number implements Type
{

	public java.lang.String toString() {
		return "[Type]: double";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(Type type) {
		if(type == null) {
			return false;
		}
		if(type instanceof Number) {
			return true;
		}
		else {
			return false;
		}
	}

	public Expression defaultValue() {
		return new NumberAtom("0");
	}
}
