package ql.semantics;

import ql.semantics.values.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nik on 22-02-2015
 */
public class ValueTable
{
    private final Map<String, Value> values;

    public ValueTable()
    {
        this.values = new HashMap<>();
    }

    public Value getValue(String key)
    {
        if (values.containsKey(key))
        {
            return values.get(key);
        }

        throw new IllegalArgumentException("The question with id \"" + key + "\" is not present in the value table.");
    }

    public void storeEntry(ValueTableEntry entry)
    {
        this.values.put(entry.getKey(), entry.getValue());
    }
}
