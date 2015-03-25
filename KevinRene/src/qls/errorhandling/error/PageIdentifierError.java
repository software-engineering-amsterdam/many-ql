package qls.errorhandling.error;

import ql.ast.QLType;
import ql.ast.expression.Identifier;

public class PageIdentifierError extends qls.errorhandling.Error {
	public PageIdentifierError(Identifier origin, QLType resolvedType) {
		super(origin, "(" + origin.getClass().getSimpleName() +  ":" 
				+ origin + ") is already in use and resolves to (" + resolvedType + ")."
				+ "It cannot be assigned to a page.");
	}
}
