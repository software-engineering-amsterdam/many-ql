package ql.semantics;

import ql.ast.statement.Question;
import ql.ast.type.Type;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class Questions implements Iterable<String>
{
    private final Map<String, List<Question>> questions;

    public Questions()
    {
        this.questions = new HashMap<>();
    }

    public void put(Question q)
    {
        String id = q.getId();
        if (this.questions.containsKey(id))
        {
            List<Question> list = this.questions.get(id);
            list.add(q);
        }
        else
        {
            List<Question> list = new ArrayList<>();
            list.add(q);
            this.questions.put(id, list);
        }
    }

    public boolean contains(String id)
    {
        return this.questions.containsKey(id);
    }

    public List<Question> getQuestionsById(String id)
    {
        return this.questions.get(id);
    }

    public Type getType(String id)
    {
        Question q = this.findById(id);
        return q.getType();
    }

    public Iterator<String> iterator()
    {
        return this.questions.keySet().iterator();
    }

    private Question findById(String id)
    {
        return this.questions.get(id).get(0);
    }
}
