package ql.semantics;

import ql.ast.expression.Expr;
import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;

import java.util.Stack;

/**
 * Created by Nik on 10-3-15.
 */
public class Flattener implements FormVisitor<Void>, StatVisitor<Void>
{
    // TODO find a better name based on the Flat class
    private final Flat flat;
    private final ConditionStack conditionStack;

    public static Flat flatten(Form f)
    {
        Flattener flattener = new Flattener();
        f.accept(flattener);
        return flattener.flat;
    }

    private Flattener()
    {
        this.flat = new Flat();
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
        Expr condition = this.conditionStack.peek();
        ConditionalQuestion cq = new ConditionalQuestion(condition, q);
        this.flat.addQuestion(cq);
    }
}
