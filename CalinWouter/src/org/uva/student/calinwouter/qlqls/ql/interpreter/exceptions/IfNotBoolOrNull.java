package org.uva.student.calinwouter.qlqls.ql.interpreter.exceptions;

public class IfNotBoolOrNull extends InterpretationException {

    public IfNotBoolOrNull() {
        super("If-expression not boolean or null.");
    }
}
