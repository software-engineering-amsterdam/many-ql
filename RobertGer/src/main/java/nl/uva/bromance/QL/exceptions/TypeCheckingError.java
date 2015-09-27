package nl.uva.bromance.QL.exceptions;

/**
 * Created by Robert on 9/22/2015.
 */
public class TypeCheckingError extends QLError {
    private Type type;

    public enum Type {ERROR, WARNING}
    public TypeCheckingError(String messsage, Type type) {
        super(messsage);
        this.type = type;
    }

    @Override
    public String getMessage() {
        return type.toString()+": "+super.getMessage();
    }
}
