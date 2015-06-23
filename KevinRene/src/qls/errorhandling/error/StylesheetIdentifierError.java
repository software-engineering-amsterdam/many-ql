package qls.errorhandling.error;

import ql.ast.QLNode;
import ql.ast.QLType;

public class StylesheetIdentifierError extends qls.errorhandling.Error {
	public StylesheetIdentifierError(QLNode origin, QLType actualType) {
		super(origin, "(" + origin.getClass().getSimpleName() + ")"
				+ " was assigned an identifier that resolves to "
				+ "(" + actualType + "), but a form is required.");
	}
}
