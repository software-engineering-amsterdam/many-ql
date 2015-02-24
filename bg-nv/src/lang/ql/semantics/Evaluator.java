package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;
import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 24-2-15.
 */
public class Evaluator implements FormVisitor<ValueTable>, StatVisitor<Void>
{

    private ValueTable valueTable;

    public static ValueTable evaluate(Form f)
    {
        Evaluator evaluator = new Evaluator();
        return evaluator.visit(f);
    }

    public static ValueTable reevaluate(Form f, ValueTable valueTable)
    {
        Evaluator evaluator = new Evaluator(valueTable);
        return  evaluator.visit(f);
    }

    private Evaluator()
    {
        this(new ValueTable());
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
        this.valueTable.storeValue(q.getId(), new UndefinedValue());

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        Expr expr = q.getDefaultValue();
        Value value = ExprEvaluator.evaluate(expr, this.valueTable);
        this.valueTable.storeValue(q.getId(), value);

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        Expr expr = c.getCondition();
        Value condition = ExprEvaluator.evaluate(expr, this.valueTable);

        if (!condition.isUndefined() && !false) // TODO check if it is true
        {
            for (Statement s : c.getBody())
            {
                s.accept(this);
            }
        }

        return null;
    }
}