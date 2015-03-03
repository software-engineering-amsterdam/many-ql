package nl.uva.se.interpreter.error;

import java.util.ArrayList;
import java.util.List;

import nl.uva.se.ast.type.Type;

public class ErrorList {
	
	private List<Error> errors;
	
	public ErrorList() {
		errors = new ArrayList<Error>();
	}
	
	public void addUndefinedTypeError(int line, int offset, String fieldName) {
		errors.add(new Error(line, offset, "undefined type", "Field " + fieldName + " is undefined!"));
	}
	
	public void addTypeNotAllowedError(int line, int offset, List<Type> expected, Type actual) {
		errors.add(new Error(line, offset, "type not allowed", "Expected type " 
				+ expected + ", but got " + actual.getTypeName()));
	}
	
	public void addTypeMissmatchError(int line, int offset, Type expected, Type leftType, Type rightType) {
		errors.add(new Error(line, offset, "type missmatch", "Expected both types to be " + expected.getTypeName()
				+ ", but got " + leftType.getTypeName() + " and " + rightType.getTypeName()));
	}
	
	public boolean hasErrors() {
		return errors.size() != 0;
	}
}
