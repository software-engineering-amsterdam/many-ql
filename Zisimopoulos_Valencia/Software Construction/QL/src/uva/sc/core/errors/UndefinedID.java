package uva.sc.core.errors;

import uva.sc.ql.atom.ID;

public class UndefinedID implements IError {

    private ID id;

    public UndefinedID(ID id) {
	this.id = id;
    }

    public String toString() {
	return "The variable " + id.getValue()
		+ " is used but has not been declared.";
    }
}
