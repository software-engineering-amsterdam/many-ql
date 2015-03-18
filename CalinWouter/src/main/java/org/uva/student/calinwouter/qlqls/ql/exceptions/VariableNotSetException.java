package org.uva.student.calinwouter.qlqls.ql.exceptions;

public class VariableNotSetException extends AbstractRuntimeInterpretationException {

    public VariableNotSetException(String var) {
        super("Variable not set: " + var);
    }

}
