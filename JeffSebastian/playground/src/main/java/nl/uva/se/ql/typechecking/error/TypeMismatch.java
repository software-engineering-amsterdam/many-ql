package nl.uva.se.ql.typechecking.error;

import nl.uva.se.ql.ast.type.Type;

public class TypeMismatch extends Error {

	public TypeMismatch(int line, int offset, Type expected, Type actual) {
		super(line, offset, "type mismatch", "expected " + expected + ", but got " + actual);
	}

}
