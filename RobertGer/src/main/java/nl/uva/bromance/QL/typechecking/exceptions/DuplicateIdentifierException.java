package nl.uva.bromance.QL.typechecking.exceptions;

public class DuplicateIdentifierException extends TypeCheckingError {
    public DuplicateIdentifierException(String messsage)
    {
        super(messsage);
    }
}
