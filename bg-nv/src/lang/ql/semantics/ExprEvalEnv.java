package lang.ql.semantics;

import lang.ql.semantics.values.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 23/02/15.
 */
public class ExprEvalEnv
{
    private Map<String, Value> valueMap;

    public ExprEvalEnv()
    {
        this.valueMap = new HashMap<String, Value>();
    }

    // TODO: remove this
    public void registerValue(String id, Value v)
    {
        this.valueMap.put(id, v);
    }

    public Value getValue(String id)
    {
        return this.valueMap.get(id);
    }
}
