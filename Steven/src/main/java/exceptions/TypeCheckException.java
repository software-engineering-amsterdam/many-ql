package exceptions;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class TypeCheckException extends RuntimeException {
    public TypeCheckException(String message) {
        super(message);
    }

    public TypeCheckException(String message, Throwable cause) {
        super(message, cause);
    }
}
