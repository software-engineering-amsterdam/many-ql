package ql.errorhandling.error;

import ql.ast.QLNode;
import ql.ast.expression.QLType;
import ql.errorhandling.Error;

public class IllegalAssignmentError extends Error {
	public IllegalAssignmentError(QLNode origin, QLType expectedType, QLType actualType) {
		super(origin, "(" + origin.getClass().getSimpleName() + "->" + expectedType 
				+ ") was assigned (" + actualType + ").");
	}
}
