package uva.sc.types;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.StringAtom;
import uva.sc.logic.Expression;


public class String implements Type{
	
	public java.lang.String toString() {
		return "[Type]: string";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(Type type) {
		if(type == null) {
			return false;
		}
		if(type instanceof String) {
			return true;
		}
		else {
			return false;
		}
	}

	public Expression defaultValue() {
		return new StringAtom("");
	}
}
