package nl.uva.softwcons.validation;

public abstract class Error {

    private final String message;

    public Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error: " + message;
    }
}
