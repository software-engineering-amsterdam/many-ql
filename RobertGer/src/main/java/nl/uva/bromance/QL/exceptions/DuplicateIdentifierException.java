package nl.uva.bromance.QL.exceptions;

public class DuplicateIdentifierException extends TypeCheckingError
{
    public DuplicateIdentifierException(String messsage)
    {
        super(messsage, Type.ERROR);
    }
}
