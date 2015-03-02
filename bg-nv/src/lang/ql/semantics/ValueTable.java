package lang.ql.semantics;

import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nik on 22-02-2015
 */
public class ValueTable
{
    private Map<String, Value> values;

    public ValueTable()
    {
        this.values = new HashMap<String, Value>();
    }

    public Value getValue(String key)
    {
        if (values.containsKey(key))
        {
            return values.get(key);
        }
        // TODO: check if this is ok
        return new UndefinedValue();
    }

    public void storeValue(String key, Value val)
    {
        values.put(key, val);
    }

    public Boolean valueExists(String key)
    {
        return values.containsKey(key);
    }
}
