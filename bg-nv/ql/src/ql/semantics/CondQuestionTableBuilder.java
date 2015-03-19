package ql.semantics;

import ql.ast.expression.Expr;
import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;

/**
 * Created by Nik on 10-3-15.
 */
public class CondQuestionTableBuilder implements FormVisitor<Void>, StatVisitor<Void>
{
    private final CondQuestionTable condQuestionTable;
    private final ConditionStack conditionStack;

    public static CondQuestionTable flatten(Form f)
    {
        CondQuestionTableBuilder builder = new CondQuestionTableBuilder();
        f.accept(builder);
        return builder.condQuestionTable;
    }

    private CondQuestionTableBuilder()
    {
        this.condQuestionTable = new CondQuestionTable();
        this.conditionStack = new ConditionStack();
    }

    @Override
    public Void visit(Form f)
    {
        for (Statement s : f.getBody())
        {
            s.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        this.conditionStack.push(c.getCondition());

        for (Statement s : c.getBody())
        {
            s.accept(this);
        }

        this.conditionStack.pop();
        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.addQuestionToFlat(q);

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.addQuestionToFlat(q);

        return null;
    }

    private void addQuestionToFlat(Question q)
    {
        Expr c = this.conditionStack.peek();
        this.condQuestionTable.addQuestion(c, q);
    }
}
