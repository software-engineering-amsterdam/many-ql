package ql.errorhandling.error;

import ql.ast.QLNode;
import ql.errorhandling.Error;

public class UndefinedVariableError extends Error {
	public UndefinedVariableError(QLNode origin) {
		super(origin, "(" + origin.getClass().getSimpleName() + ") is used before being defined.");
	}
}
