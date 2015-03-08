package nl.uva.se.interpreter.error;

import nl.uva.se.ast.type.Type;

public class TypeNotAllowed extends Error {

	public TypeNotAllowed(int line, int offset, Type type, String operation) {
		super(line, offset, "type not allowed", type + " not allowed for " + operation);
	}

}
