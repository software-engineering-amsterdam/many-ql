package nl.uva.bromance.QL.typechecking.exceptions;

public class DuplicateQuestionIdentifierException extends TypeCheckingError {
    public DuplicateQuestionIdentifierException(String messsage)
    {
        super(messsage);
    }
}
