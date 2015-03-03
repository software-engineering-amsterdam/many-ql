package org.uva.student.calinwouter.qlqls.ql.exceptions;

public class NotOfTypeException extends InterpretationException {
    public NotOfTypeException(String type) {
        super("Expression not of type: " + type);
    }
}
