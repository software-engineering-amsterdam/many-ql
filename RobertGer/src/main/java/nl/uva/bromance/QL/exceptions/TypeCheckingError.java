package nl.uva.bromance.QL.exceptions;

public class TypeCheckingError extends QLError
{
    public enum Type {ERROR, WARNING}

    private Type type;

    public boolean isWarning()
    {
        return type == Type.WARNING;
    }

    public TypeCheckingError(String messsage, Type type)
    {
        super(messsage);
        this.type = type;
    }

    @Override
    public String getMessage()
    {
        return type.toString()+": "+super.getMessage();
    }
}
