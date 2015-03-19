package ql.semantics;

import ql.semantics.values.Value;

/**
 * Created by Nik on 16-03-2015
 */
// TODO: this is code smell and it creeps the api of the ValueTable. Did you create this class because the notifyObservers
// method accepts a single object as a param? If this is the case, lets just pass an array there instead of use this class
// throughout the project (and even in the tests!)
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
