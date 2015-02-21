package nl.uva.softwcons.validation.typechecker.error;

import nl.uva.softwcons.validation.Error;

public class InvalidQuestionExpressionType extends Error {
    private static final String ERROR_TEXT = "Expression type in question does not match question type.";

    public InvalidQuestionExpressionType() {
        super(ERROR_TEXT);
    }

}
