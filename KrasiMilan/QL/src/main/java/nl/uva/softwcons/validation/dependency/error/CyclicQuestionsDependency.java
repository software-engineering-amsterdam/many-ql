package nl.uva.softwcons.validation.dependency.error;

import nl.uva.softwcons.validation.Error;

public class CyclicQuestionsDependency extends Error {
    private static final String ERROR_TEXT = "Cyclic dependency between questions.";

    public CyclicQuestionsDependency() {
        super(ERROR_TEXT);
    }

}
