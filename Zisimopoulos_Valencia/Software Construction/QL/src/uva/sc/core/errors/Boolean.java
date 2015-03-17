package uva.sc.core.errors;


public class Boolean implements IError {
    public String toString() {
	return "Boolean operations only allow operands of type "
		+ Boolean.class;
    }
}
