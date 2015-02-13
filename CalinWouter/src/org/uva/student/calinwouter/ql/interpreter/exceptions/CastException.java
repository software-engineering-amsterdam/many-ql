package org.uva.student.calinwouter.ql.interpreter.exceptions;

public class CastException extends InterpretationException {

    private static String createTypeCheckExceptionString(String method, Class<?>... classes) {
        StringBuilder sb = new StringBuilder();
        for (Class<?> clazz : classes) {
            sb.append(clazz);
            sb.append(" ");
        }
        return "Cannot call '" + method + ", using types: " + sb.toString();
    }

    public CastException(String exp, Class<?>... classes) {
        super(createTypeCheckExceptionString(exp, classes));
    }

}
