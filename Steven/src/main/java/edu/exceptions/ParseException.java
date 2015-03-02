package edu.exceptions;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class ParseException extends RuntimeException {
    public ParseException(String message) {
        super(message);
    }

    public ParseException(Throwable cause) {
        super(cause);
    }
}
