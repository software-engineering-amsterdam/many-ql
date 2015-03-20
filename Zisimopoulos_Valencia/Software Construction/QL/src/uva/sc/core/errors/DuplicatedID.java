package uva.sc.core.errors;

import uva.sc.ql.atom.ID;


public class DuplicatedID implements IError {

    ID id;

    public DuplicatedID(ID i) {
	id = i;
    }

    public String toString() {
	return "Duplicated identifier" + id.getValue();
    }

}
