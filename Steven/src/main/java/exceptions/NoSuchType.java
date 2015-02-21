package exceptions;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class NoSuchType extends Exception {
    public NoSuchType(String message) {
        super(message);
    }

    public NoSuchType(String message, Throwable cause) {
        super(message, cause);
    }
}
