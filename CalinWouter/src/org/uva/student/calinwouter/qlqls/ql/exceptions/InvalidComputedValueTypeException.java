package org.uva.student.calinwouter.qlqls.ql.exceptions;

public class InvalidComputedValueTypeException extends InterpretationException {

    public InvalidComputedValueTypeException(String expected, String found) {
        super("Invalid Computed Value Type. Expected: " + expected + ", found: " + found);
    }
}
