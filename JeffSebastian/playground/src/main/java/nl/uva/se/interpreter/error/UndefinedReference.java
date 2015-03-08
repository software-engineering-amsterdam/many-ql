package nl.uva.se.interpreter.error;

public class UndefinedReference extends Error {

	public UndefinedReference(int line, int offset, String fieldName) {
		super(line, offset, "undefined reference", fieldName + " is undefined!");
	}

}
