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
    private static final BoolValue trueValue = new BoolValue(true);
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
        this.valueTable.storeEntry(new ValueTableEntry(q.getId(), new UndefValue()));

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        Expr expr = q.getCalculation();

        Value value = ExprEvaluator.evaluate(expr, this.valueTable);
        this.valueTable.storeEntry(new ValueTableEntry(q.getId(), value));

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        Expr expr = c.getCondition();
        Value condValue = ExprEvaluator.evaluate(expr, this.valueTable);

        if (this.isCondValueTrue(condValue))
        {
            for (Statement s : c.getBody())
            {
                s.accept(this);
            }
        }

        return null;
    }

    private boolean isCondValueTrue(Value v)
    {
        Value result = v.equBoolean(trueValue);
        return result.isTrue();
    }
}