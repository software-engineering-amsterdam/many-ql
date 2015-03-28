package nl.uva.bromance.ast.exceptions;

import nl.uva.bromance.typechecking.TypeCheckingException;

/**
 * Created by Ger on 24-2-2015.
 */
public class TypecheckingInvalidOperandException extends TypeCheckingException {

    public TypecheckingInvalidOperandException(String message) {
        super(message);
    }
}
