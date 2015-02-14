package org.uva.student.calinwouter.ql.interpreter.exceptions;

public class VariableNotSetException extends InterpretationException {

    public VariableNotSetException(String var) {
        super("Variable not set: " + var);
    }

}
