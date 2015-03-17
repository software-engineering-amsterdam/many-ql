package ql.semantics;

import ql.semantics.values.Value;

/**
 * Created by Nik on 16-03-2015
 */
public class ValueTableEntry
{
    private final String key;
    private final Value value;

    public ValueTableEntry(String key, Value value)
    {
        this.key = key;
        this.value = value;
    }

    public Value getValue()
    {
        return value;
    }

    public String getKey()
    {
        return key;
    }
}
