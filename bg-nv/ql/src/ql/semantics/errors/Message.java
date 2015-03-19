package ql.semantics.errors;

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

    @Override
    public String toString()
    {
        return this.getMessage();
    }

    public abstract boolean isError();
}
