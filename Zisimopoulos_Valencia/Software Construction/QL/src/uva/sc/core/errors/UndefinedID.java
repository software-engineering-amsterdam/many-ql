package uva.sc.core.errors;

import uva.sc.ql.atom.ID;

public class UndefinedID implements IError {

    ID identity;

    public UndefinedID(ID id) {
	identity = id;
    }

    public String toString() {
	return "The variable " + identity.getValue()
		+ " is used but has not been declared.";
    }
}
