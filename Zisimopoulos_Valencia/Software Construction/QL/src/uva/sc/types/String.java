package uva.sc.types;

import uva.sc.ast.INodeVisitor;


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
}
