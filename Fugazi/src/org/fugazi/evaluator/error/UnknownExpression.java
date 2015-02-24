package org.fugazi.evaluator.error;

public class UnknownExpression extends Exception {

    public UnknownExpression() {
        super();
    }

    public UnknownExpression(String message) {
        super(message);
    }

    public UnknownExpression(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownExpression(Throwable cause) {
        super(cause);
    }
}