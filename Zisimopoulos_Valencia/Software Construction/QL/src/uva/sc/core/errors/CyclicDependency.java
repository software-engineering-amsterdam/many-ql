package uva.sc.core.errors;

public class CyclicDependency implements IError {

    String identity;

    public CyclicDependency(String id) {
	identity = id;
    }

    public String toString() {
	return "Circular dependency has been detected in question with identifier "
		+ identity;
    }
}
