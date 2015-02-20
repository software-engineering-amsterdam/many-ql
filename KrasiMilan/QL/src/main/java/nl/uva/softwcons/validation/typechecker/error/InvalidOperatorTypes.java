package nl.uva.softwcons.validation.typechecker.error;

import nl.uva.softwcons.validation.Error;

public class InvalidOperatorTypes extends Error {
    private static final String ERROR_TEXT = "Invalid operand types to operator.";

    public InvalidOperatorTypes() {
        super(ERROR_TEXT);
    }
}
