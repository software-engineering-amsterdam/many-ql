package uva.sc.types;

import uva.sc.ast.INodeVisitor;

public class Unidentified implements Type {

	public java.lang.String toString() {
		return "[Type]: undefined";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(Type type) {
		if(type == null) {
			return false;
		}
		if(type instanceof Unidentified) {
			return true;
		}
		else {
			return false;
		}
	}
}
