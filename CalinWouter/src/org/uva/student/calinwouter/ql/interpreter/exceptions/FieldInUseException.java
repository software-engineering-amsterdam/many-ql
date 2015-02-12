package org.uva.student.calinwouter.ql.interpreter.exceptions;

public class FieldInUseException extends InterpretationException {

    public FieldInUseException(String lbl) {
        super("Field already in use: " + lbl);
    }

}
