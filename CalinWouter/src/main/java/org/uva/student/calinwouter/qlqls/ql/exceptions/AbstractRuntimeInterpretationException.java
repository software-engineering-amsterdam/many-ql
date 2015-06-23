package org.uva.student.calinwouter.qlqls.ql.exceptions;

public abstract class AbstractRuntimeInterpretationException extends RuntimeException {

    public AbstractRuntimeInterpretationException(String expression) {
        super(expression);
    }

}
