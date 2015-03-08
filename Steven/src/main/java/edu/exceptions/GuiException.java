package edu.exceptions;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class GuiException extends RuntimeException {
    public GuiException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuiException(String message) {
        super(message);
    }
}
