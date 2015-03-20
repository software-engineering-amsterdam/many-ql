package nl.uva.se.ql.typechecking.error;

public class UndefinedReference extends Error {

	public UndefinedReference(int line, int offset, String fieldName) {
		super(line, offset, "undefined reference", fieldName + " is undefined!");
	}

}
