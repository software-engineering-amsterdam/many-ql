package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;

/**
 * Created by bore on 13/02/15.
 */
public class QuestionCollector implements FormVisitor<Void>, StatVisitor<Void>
{
    private final Questions questions;

    public static Questions collect(Form f)
    {
        QuestionCollector visitor = new QuestionCollector();
        f.accept(visitor);

        return visitor.questions;
    }

    private QuestionCollector()
    {
        this.questions = new Questions();
    }

    @Override
    public Void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition condition)
    {
        for (Statement statement : condition.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.questions.put(q);

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.questions.put(q);

        return null;
    }
}
