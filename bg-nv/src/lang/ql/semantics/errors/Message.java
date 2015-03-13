package lang.ql.semantics.errors;

/**
 * Created by bore on 20/02/15.
 */
public abstract class Message
{
    private String message;

    public Message(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public abstract boolean isError();
}
