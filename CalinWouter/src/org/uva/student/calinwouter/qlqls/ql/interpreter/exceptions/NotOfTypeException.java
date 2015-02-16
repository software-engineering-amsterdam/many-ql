package org.uva.student.calinwouter.qlqls.ql.interpreter.exceptions;

public class NotOfTypeException extends InterpretationException {
    public NotOfTypeException(String type) {
        super("Expression not of type: " + type);
    }
}
