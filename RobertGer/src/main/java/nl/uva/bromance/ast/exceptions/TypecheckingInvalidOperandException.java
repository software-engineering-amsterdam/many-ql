package nl.uva.bromance.ast.exceptions;

import nl.uva.bromance.typechecking.TypeCheckingException;

public class TypecheckingInvalidOperandException extends TypeCheckingException {

    public TypecheckingInvalidOperandException(String message) {
        super(message);
    }
}
