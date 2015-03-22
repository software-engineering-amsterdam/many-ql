package ql.semantics;

import ql.ast.expression.*;
import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.semantics.values.*;

/**
 * Created by Nik on 24-2-15.
 */
public class Evaluator implements FormVisitor<Void>, StatVisitor<Void>
{
    private final ValueTable valueTable;

    public static ValueTable evaluate(Form f)
    {
        Evaluator evaluator = new Evaluator();
        f.accept(evaluator);

        return evaluator.valueTable;
    }

    private Evaluator()
    {
        this.valueTable = new ValueTable();
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
    public Void visit(Question q)
    {
        this.valueTable.storeEntry(q.getId(), new UndefValue());

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        Expr expr = q.getCalculation();

        Value value = ExprEvaluator.evaluate(expr, this.valueTable);
        this.valueTable.storeEntry(q.getId(), value);

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        for (Statement s : c.getBody())
        {
            s.accept(this);
        }
        return null;
    }
}