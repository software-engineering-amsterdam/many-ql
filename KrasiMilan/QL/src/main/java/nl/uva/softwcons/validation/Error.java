package nl.uva.softwcons.validation;

public abstract class Error {

    private final String message;

    public Error(String message) {
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

    @Override
    public String toString() {
        return "Error: " + message;
    }
}
