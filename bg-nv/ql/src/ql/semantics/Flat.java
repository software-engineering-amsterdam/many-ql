package ql.semantics;

import ql.ast.expression.Expr;
import ql.ast.statement.Question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nik on 10-3-15.
 */
public class Flat implements Iterable<ConditionalQuestion>
{
    // TODO: find a better name and probably remove ConditionalQuestion smelly class
    private final List<ConditionalQuestion> flat;

    public Flat()
    {
        this.flat = new ArrayList<>();
    }

    //TODO: remove one of these methods
    public void addQuestion(Expr condition, Question question)
    {
        ConditionalQuestion q = new ConditionalQuestion(condition, question);
        this.flat.add(q);
    }

    public void addQuestion(ConditionalQuestion q)
    {
        this.flat.add(q);
    }

    @Override
    public Iterator<ConditionalQuestion> iterator()
    {
        return flat.iterator();
    }

    public ConditionalQuestion getConditionalQuestion(String questionId)
    {
        return this.flat.stream()
                .filter(q -> q.getQuestion().getId().equals(questionId))
                .findFirst()
                .get();
    }
}
