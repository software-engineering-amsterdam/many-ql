package uva.sc.core.errors;

public class UndefinedID implements IError {

    String identity;

    public UndefinedID(String id) {
	identity = id;
    }

    public String toString() {
	return "The variable " + identity
		+ " is used but has not been declared.";
    }
}
