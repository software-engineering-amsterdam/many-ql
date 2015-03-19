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
        assert this.values.containsKey(key);

        return this.values.get(key);
    }

    public void storeEntry(ValueTableEntry entry)
    {
        this.values.put(entry.getKey(), entry.getValue());
    }
}
