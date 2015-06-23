package ql.semantics;

import ql.util.StringHelper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bore on 12/03/15.
 */
public class Identifiers
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
    public String toString()
    {
        return StringHelper.printStrValueList(this.identifiers, ", ");
    }
}
