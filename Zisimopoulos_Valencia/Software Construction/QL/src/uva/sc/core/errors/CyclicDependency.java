package uva.sc.core.errors;

import uva.sc.ql.atom.ID;

public class CyclicDependency implements IError {

    private ID id;

    public CyclicDependency(ID id) {
	this.id = id;
    }

    public String toString() {
	return "Circular dependency has been detected in question with identifier "
		+ id.getValue();
    }
}
