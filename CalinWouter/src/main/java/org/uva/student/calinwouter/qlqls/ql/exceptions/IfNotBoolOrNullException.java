package org.uva.student.calinwouter.qlqls.ql.exceptions;

public class IfNotBoolOrNullException extends InterpretationException {

    public IfNotBoolOrNullException() {
        super("If-expression not boolean or null.");
    }
}
