package org.uva.student.calinwouter.qlqls.ql.exceptions;

public class FieldInUseException extends InterpretationException {

    public FieldInUseException(String lbl) {
        super("Field already in use: " + lbl);
    }

}
