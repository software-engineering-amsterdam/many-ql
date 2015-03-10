package lang.ql.semantics.errors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 10/03/15.
 */
public class Messages
{
    private List<Message> messages;

    public Messages()
    {
        this.messages = new ArrayList<>();
    }

    public void add(Message m)
    {
        this.messages.add(m);
    }

    public boolean containsErrors()
    {
        for (Message m : this.messages)
        {
            if (m.isError())
            {
                return true;
            }
        }

        return false;
    }

    public int size()
    {
        return this.messages.size();
    }

    public Message get(int i)
    {
        return this.messages.get(i);
    }
}
