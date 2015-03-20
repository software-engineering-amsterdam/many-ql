package ql.semantics;

import ql.ast.expression.Expr;
import ql.ast.statement.Question;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nik on 10-3-15.
 */
public class CondQuestionTable implements Iterable<Question>
{
    private final List<Question> ids;
    private final Map<Question, Expr> idToCondition;

    public CondQuestionTable()
    {
        this.ids = new ArrayList<>();
        this.idToCondition = new HashMap<>();
    }

    public void addQuestion(Expr condition, Question question)
    {
        this.ids.add(question);
        this.idToCondition.put(question, condition);
    }

    public Expr getCondition(String questionId)
    {
        List<Question> qs = this.getQuestionsWithId(questionId);
        return this.idToCondition.get(qs.get(0));
    }

    public Question getQuestion(String questionId)
    {
        List<Question> qs = this.getQuestionsWithId(questionId);
        return qs.get(0);
    }

    @Override
    public Iterator<Question> iterator()
    {
        return this.ids.iterator();
    }

    private List<Question> getQuestionsWithId(String id)
    {
        return this.idToCondition.keySet().stream()
                .filter(q -> q.getId().equals(id))
                .collect(Collectors.toList());
    }
}
