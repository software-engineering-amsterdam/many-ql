package uva.sc.qls.types;

import uva.sc.qls.ast.*;

public class String implements Type{
	
	public java.lang.String toString() {
		return "[Type]: string";
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

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
