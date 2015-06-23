package uva.sc.core.errors;

import uva.sc.core.types.Number;

public class Arithmetic implements IError {

    public String toString() {
	return "Arithmetic operations only allow operands of type "
		+ Number.class;
    }
}
