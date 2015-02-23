package nl.uva.softwcons.validation.labels.error;

import nl.uva.softwcons.validation.Error;

public class DuplicateLabel extends Error {
    private static final String ERROR_TEXT = "Duplicate question labels.";

    public DuplicateLabel() {
        super(ERROR_TEXT);
    }

    @Override
    public boolean isFatal() {
        return false;
    }

}
