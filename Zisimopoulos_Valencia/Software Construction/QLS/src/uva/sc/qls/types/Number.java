package uva.sc.qls.types;

import uva.sc.qls.ast.*;

public class Number implements Type {

	public java.lang.String toString() {
		return "[Type]: number";
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

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
