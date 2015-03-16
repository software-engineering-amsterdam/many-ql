package ql.errorhandling.error;

import ql.ast.QLNode;
import ql.errorhandling.Error;

public class RedefinedVariableError extends Error {
	public RedefinedVariableError(QLNode origin) {
		super(origin, "(" + origin.getClass().getSimpleName() + ") is defined multiple times.");
	}
}
