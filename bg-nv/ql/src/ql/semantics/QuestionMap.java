package ql.semantics;

import ql.ast.statement.Question;
import ql.ast.type.Type;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class QuestionMap implements Iterable<String>
{
    private final Map<String, Question> questionMap;

    public QuestionMap()
    {
        this.questionMap = new HashMap<>();
    }

    public void put(Question q)
    {
        this.questionMap.put(q.getId(), q);
    }

    public boolean contains(String id)
    {
        return this.questionMap.containsKey(id);
    }

    public Question get(String id)
    {
        return this.questionMap.get(id);
    }

    public Type getType(String id)
    {
        return this.questionMap.get(id).getType();
    }

    public Iterator<String> iterator()
    {
        return this.questionMap.keySet().iterator();
    }
}
