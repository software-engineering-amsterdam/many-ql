package uva.sc.core.errors;

import uva.sc.ql.atom.ID;

public class DuplicatedID implements IError {

    private ID id;

    public DuplicatedID(ID id) {
	this.id = id;
    }

    public String toString() {
	return "Duplicated identifier" + id.getValue();
    }

}
