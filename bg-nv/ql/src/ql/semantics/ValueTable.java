package ql.semantics;

import ql.semantics.values.UndefValue;
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
        // TODO: check if this is ok
        // Boryana: in the Evaluator class (where the ValueTable is constructed) the visit(Question q) method
        // adds a question and passes an undefined value. If your value table does not contain the id,
        // then the Evaluator is not traversing the whole ql.ast. Returning an Undefined value will only mask the problem.
        // May be an assert will be better in this case?

        return new UndefValue();
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
