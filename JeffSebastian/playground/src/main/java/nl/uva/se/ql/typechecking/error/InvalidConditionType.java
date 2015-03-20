package nl.uva.se.ql.typechecking.error;

import nl.uva.se.ql.ast.type.Type;

public class InvalidConditionType extends Error {

	public InvalidConditionType(int line, int offset, Type conditionType) {
		super(line, offset, "invalid condition type",
				"expected boolean, but got " + conditionType);
	}

}
