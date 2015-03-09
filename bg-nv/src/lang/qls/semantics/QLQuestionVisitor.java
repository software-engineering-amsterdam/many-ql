package lang.qls.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;

/**
 * Created by bore on 03/03/15.
 */
public class QLQuestionVisitor implements FormVisitor<Void>, StatVisitor<Void>
{
    private QuestTypes questionMap;

    public static QuestTypes extractQuestions(Form f)
    {
        QLQuestionVisitor visitor = new QLQuestionVisitor();
        f.accept(visitor);

        return visitor.questionMap;
    }

    private QLQuestionVisitor()
    {
        this.questionMap = new QuestTypes();
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
        this.registerQuestion(q);
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.registerQuestion(q);
        return null;
    }

    private void registerQuestion(Question q)
    {
        this.questionMap.add(q.getId(), q.getType());
    }
}