package org.uva.student.calinwouter.ql.interpreter.exceptions;

public class InvalidComputedValueType extends InterpretationException {

    public InvalidComputedValueType(String expected, String found) {
        super("Invalid Computed Value Type. Expected: " + expected + ", found: " + found);
    }
}
