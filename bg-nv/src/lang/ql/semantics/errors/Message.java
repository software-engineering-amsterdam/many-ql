package lang.ql.semantics.errors;

import java.util.List;

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

    protected static String getListString(List<String> l)
    {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < l.size(); i++)
        {
            b.append(l.get(i));
            if (i < l.size()-1)
            {
                b.append(", ");
            }
        }

        return b.toString();
    }
}
