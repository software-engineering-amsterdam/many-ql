package nl.uva.softwcons.validation.typechecker.error;

import nl.uva.softwcons.validation.Error;

public class InvalidConditionType extends Error {
    private static final String ERROR_TEXT = "Expression in condition statetement should be boolean";

    public InvalidConditionType() {
        super(ERROR_TEXT);
    }

}
