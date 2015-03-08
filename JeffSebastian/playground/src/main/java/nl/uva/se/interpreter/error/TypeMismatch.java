package nl.uva.se.interpreter.error;

import nl.uva.se.ast.type.Type;

public class TypeMismatch extends Error {

	public TypeMismatch(int line, int offset, Type expected, Type actual) {
		super(line, offset, "type mismatch", "expected " + expected + ", but got " + actual);
	}

}
