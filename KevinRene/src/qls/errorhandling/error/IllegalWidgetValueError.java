package qls.errorhandling.error;

import ql.ast.QLNode;
import ql.ast.QLType;

public class IllegalWidgetValueError extends qls.errorhandling.Error {
	public IllegalWidgetValueError(QLNode origin, QLType expectedType) {
		super(origin, "(" + origin.getClass().getSimpleName() + ") "
				+ " only accept values of type (" + expectedType + ").");
	}
}
