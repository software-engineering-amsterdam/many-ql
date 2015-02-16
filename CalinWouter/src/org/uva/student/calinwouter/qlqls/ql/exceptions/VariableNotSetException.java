package org.uva.student.calinwouter.qlqls.ql.exceptions;

public class VariableNotSetException extends InterpretationException {

    public VariableNotSetException(String var) {
        super("Variable not set: " + var);
    }

}
