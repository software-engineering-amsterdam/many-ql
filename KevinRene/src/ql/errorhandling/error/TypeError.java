package ql.errorhandling.error;

import ql.ast.QLNode;
import ql.ast.QLType;
import ql.errorhandling.Error;

public class TypeError extends Error {	
	public TypeError(QLNode origin, QLType type) {
		super(origin, "Incompatible type: " + type.toString() + ".");
	}
	
	public TypeError(QLNode origin, QLType lhs, QLType rhs) {		
		super(origin, "(" + origin.toString() + ") " + lhs.toString() + " and " + rhs.toString() + " are incompatible.");
	}
}
