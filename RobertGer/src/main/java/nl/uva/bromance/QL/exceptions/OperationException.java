package nl.uva.bromance.QL.exceptions;

public class OperationException extends TypeCheckingError
{
    public OperationException(String message)
    {
        super(message, Type.ERROR);
    }
}
