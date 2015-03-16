package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.ast.type.Type;
import ql.semantics.errors.*;
import ql.semantics.errors.Error;

/**
 * Created by bore on 13/02/15.
 */
public class QuestionCollector implements FormVisitor<Void>, StatVisitor<Void>
{
    private final QuestionSet questionSet;

    public static QuestionSet collect(Form f)
    {
        QuestionCollector visitor = new QuestionCollector();
        f.accept(visitor);

        return visitor.questionSet;
    }

    private QuestionCollector()
    {
        this.questionSet = new QuestionSet();
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
        this.questionSet.put(q);
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.questionSet.put(q);
        return null;
    }
}
