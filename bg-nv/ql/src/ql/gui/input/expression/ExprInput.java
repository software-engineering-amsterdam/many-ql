package ql.gui.input.expression;

import ql.ast.expression.Expr;
import ql.gui.Refreshable;
import ql.gui.input.Input;
import ql.semantics.ExprEvaluator;
import ql.semantics.ValueTable;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public abstract class ExprInput extends Input implements Refreshable
{
    final private Expr expression;

    public ExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, visible, true);
        this.expression = expression;
    }

    public Expr getExpression()
    {
        return this.expression;
    }

    @Override
    public Value evaluate(ValueTable valueTable)
    {
        Value val = ExprEvaluator.evaluate(this.getExpression(), valueTable);
        valueTable.storeValue(this.getId(), val);
        return val;
    }

    @Override
    public void update(ValueTable valueTable)
    {
        // empty implementation, the this element should never be updated
    }

    @Override
    public Boolean isRefreshPrerequisite()
    {
        return true;
    }

    public abstract void setValue(Value value);

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        Value val = valueTable.getValue(this.getId());
        this.setValue(val);
    }

}