package nl.uva.softwcons.ql.validation;

public abstract class Error {
    private final String message;

    public Error(final String message) {
        this.message = message;
    }

    /**
     * Indicates whether the error is fatal.
     * 
     * @return True if the error is fatal and false otherwise
     */
    public boolean isFatal() {
        return true;
    }

    public String getMessage() {
        return message;
    }
}
