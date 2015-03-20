package uva.sc.core.errors;

import uva.sc.ql.atom.ID;

public class CyclicDependency implements IError {

    ID identity;

    public CyclicDependency(ID id) {
	identity = id;
    }

    public String toString() {
	return "Circular dependency has been detected in question with identifier "
		+ identity.getValue();
    }
}
