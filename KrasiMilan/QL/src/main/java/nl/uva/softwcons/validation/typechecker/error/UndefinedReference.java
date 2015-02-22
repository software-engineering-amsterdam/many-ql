package nl.uva.softwcons.validation.typechecker.error;

import nl.uva.softwcons.validation.Error;

public class UndefinedReference extends Error {
    private static final String ERROR_TEXT = "Undefined variable.";

    public UndefinedReference() {
        super(ERROR_TEXT);
    }

}
