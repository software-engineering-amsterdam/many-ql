package org.uva.student.calinwouter.ql.interpreter.exceptions;

public class LabelInUseException extends InterpretationException {

    public LabelInUseException(String lbl) {
        super("Label already in use: " + lbl);
    }

}
