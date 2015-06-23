package ql.semantics.errors;

import ql.util.StringHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString()
    {
        List<String> ms = this.messages.stream()
                .map(m -> m.toString())
                .collect(Collectors.toList());

        return StringHelper.printStrValueList(ms, "\n");
    }
}
