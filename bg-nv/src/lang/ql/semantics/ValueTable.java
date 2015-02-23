package lang.ql.semantics;

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
        // TODO: deal with this?
        return null;
    }

    public void storeValue(String key, Value val)
    {
        if (!values.containsKey(key))
        {
            values.put(key, val);
        }
        // TODO: deal with this?
    }

    public Boolean valueExists(String key)
    {
        return values.containsKey(key);
    }
}
