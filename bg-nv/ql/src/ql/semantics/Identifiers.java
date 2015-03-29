package ql.semantics;

import ql.util.StringHelper;

import java.util.*;

/**
 * Created by bore on 12/03/15.
 */
public class Identifiers implements Iterable<String>
{
    private final Set<String> identifiers;

    public Identifiers()
    {
        this.identifiers = new HashSet<>();
    }

    public void add(String s)
    {
        this.identifiers.add(s);
    }

    public void addAll(Collection<String> c)
    {
        this.identifiers.addAll(c);
    }

    public int size()
    {
        return this.identifiers.size();
    }

    @Override
    public Iterator<String> iterator()
    {
        return this.identifiers.iterator();
    }

    @Override
    public String toString()
    {
        return StringHelper.printStrValueList(this, ", ");
    }
}
