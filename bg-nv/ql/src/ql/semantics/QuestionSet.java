package ql.semantics;

import ql.ast.statement.Question;
import ql.ast.type.Type;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class QuestionSet implements Iterable<Question>
{
    private final Set<Question> questions;

    public QuestionSet()
    {
        this.questions = new HashSet<>();
    }

    public void put(Question q)
    {
        this.questions.add(q);
    }

    private Question findById(String id)
    {
        for (Question q : this.questions)
        {
            if (q.getId().equals(id))
            {
                return q;
            }
        }

        throw new IllegalStateException("Question not found in the set");
    }

    public boolean contains(String id)
    {
        for (Question q : this.questions)
        {
            if (q.getId().equals(id))
            {
                return true;
            }
        }

        return false;
    }

    public int getLineNumber(String id)
    {
        Question q = this.findById(id);
        return q.getLineNumber();
    }

    public Type getType(String id)
    {
        Question q = this.findById(id);
        return q.getType();
    }

    public Iterator<Question> iterator()
    {
        return this.questions.iterator();
    }
}
