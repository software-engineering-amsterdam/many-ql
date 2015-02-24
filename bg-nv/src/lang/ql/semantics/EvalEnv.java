package lang.ql.semantics;

import lang.ql.semantics.values.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 23/02/15.
 */
public class EvalEnv
{
    private Map<String, Value> valueMap;

    public EvalEnv()
    {
        this.valueMap = new HashMap<String, Value>();
    }


}
