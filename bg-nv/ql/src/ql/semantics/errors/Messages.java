package ql.semantics.errors;

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

    public void addAll(Messages ms)
    {
        this.messages.addAll(ms.messages);
    }

    // TODO: These methods are exposed for testing; So refactoring one smell causes another, sigh
    public boolean containsError()
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

    public Message get(int i)
    {
        return this.messages.get(i);
    }

    public int size()
    {
        return this.messages.size();
    }
}
