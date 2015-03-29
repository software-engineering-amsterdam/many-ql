package org.uva.student.calinwouter.qlqls.ql.exceptions;

public class FieldNotFoundException extends AbstractRuntimeInterpretationException {

    public FieldNotFoundException(String field) {
        super("Field not found: " + field);
    }

}
