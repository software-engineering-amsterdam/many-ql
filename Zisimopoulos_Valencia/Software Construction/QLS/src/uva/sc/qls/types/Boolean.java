package uva.sc.qls.types;

import uva.sc.qls.ast.*;

public class Boolean implements Type {
		
	public java.lang.String toString() {
		return "[Type]: boolean";
	}

	public boolean equals(Type type) {
		if(type == null) {
			return false;
		}
		if(type instanceof Boolean)	{
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
