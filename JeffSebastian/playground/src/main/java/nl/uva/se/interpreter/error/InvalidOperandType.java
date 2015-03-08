package nl.uva.se.interpreter.error;

import java.util.List;

import nl.uva.se.ast.type.Type;

public class InvalidOperandType extends Error {

	public InvalidOperandType(int line, int offset, Type expected, Type... actual) {
		super(line, offset, "invalid operand type", "expected " + expected
				+ ", but got " + actual);
	}

}
