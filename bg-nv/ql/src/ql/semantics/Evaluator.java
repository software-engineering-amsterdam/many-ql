package ql.semantics;

import ql.ast.expression.*;
import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.semantics.values.*;

/**
 * Created by Nik on 24-2-15.
 */
public class Evaluator implements FormVisitor<ValueTable>, StatVisitor<Void>
{
    private ValueTable valueTable;

    public static ValueTable evaluate(Form f)
    {
        ValueTable table = new ValueTable();
        Evaluator evaluator = new Evaluator(table);
        return f.accept(evaluator);
    }

    private Evaluator(ValueTable valueTable)
    {
        this.valueTable = valueTable;
    }

    @Override
    public ValueTable visit(Form f)
    {
        for (Statement s : f.getBody())
        {
            s.accept(this);
        }

        return this.valueTable;
    }

    @Override
    public Void visit(Question q)
    {
        this.valueTable.storeValue(q.getId(), new UndefValue());

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        Expr expr = q.getCalculation();

        Value value = ExprEvaluator.evaluate(expr, this.valueTable);
        this.valueTable.storeValue(q.getId(), value);

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        Expr expr = c.getCondition();
        Value condValue = ExprEvaluator.evaluate(expr, this.valueTable);

        // TODO is there a nicer way to do this?
        if (!condValue.isUndefined() && condValue instanceof BoolValue && ((BoolValue) condValue).getValue())
        {
            for (Statement s : c.getBody())
            {
                s.accept(this);
            }
        }

        return null;
    }
}