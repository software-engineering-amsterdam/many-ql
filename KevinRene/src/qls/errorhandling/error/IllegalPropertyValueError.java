package qls.errorhandling.error;

import ql.ast.QLNode;
import ql.ast.QLType;

public class IllegalPropertyValueError extends qls.errorhandling.Error {
	public IllegalPropertyValueError(QLNode origin, QLType actualType) {
		super(origin, "(" + origin.getClass().getSimpleName() + ") "
				+ "is incompatible with (" + actualType + ").");
	}
}
