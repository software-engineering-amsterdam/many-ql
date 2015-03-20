package qls.errorhandling.error;

import ql.ast.expression.Identifier;

public class DuplicateIdentifierError extends qls.errorhandling.Error {
	public DuplicateIdentifierError(Identifier origin) {
		super(origin, "(" + origin.getClass().getSimpleName() 
				+  " : " + origin + ") is used multiple times.");
	}
}
