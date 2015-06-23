package nl.uva.se.ql.typechecking.error;

import nl.uva.se.ql.ast.type.Type;

public class TypeNotAllowed extends Error {

	public TypeNotAllowed(int line, int offset, Type type, String operation) {
		super(line, offset, "type not allowed", type + " not allowed for " + operation);
	}

}
