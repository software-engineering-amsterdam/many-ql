package lang.qls.semantics;

import lang.ql.ast.type.Type;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */
public class QuestionTypeMap implements Iterable<String>
{
    private Map<String, Type> questToTypes;

    public QuestionTypeMap()
    {
        this.questToTypes = new HashMap<>();
    }

    public void add(String id, Type t)
    {
        this.questToTypes.put(id, t);
    }

    public Type getType(String id)
    {
        return this.questToTypes.get(id);
    }

    public boolean containsQuestion(String id)
    {
        return this.questToTypes.containsKey(id);
    }

    public Iterator<String> iterator()
    {
        return this.questToTypes.keySet().iterator();
    }
}
