package nl.uva.softwcons.validation.typechecker.error;

import nl.uva.softwcons.validation.Error;

public class DuplicateQuestion extends Error {
    private static final String ERROR_TEXT = "Duplicate question identifiers.";

    public DuplicateQuestion() {
        super(ERROR_TEXT);
    }

}
