package ql.semantics.errors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bore on 10/03/15.
 */
public class Messages implements Iterable<Message>
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

    public Iterator<Message> iterator()
    {
        return this.messages.iterator();
    }
}
