package org.uva.student.calinwouter.qlqls.qls.exceptions;

public class CouldNotFindMatchingQLSComponentException extends Exception {

    public CouldNotFindMatchingQLSComponentException(String clazz) {
        super("Could not find matching QLS component for " + clazz + ".");
    }

}
