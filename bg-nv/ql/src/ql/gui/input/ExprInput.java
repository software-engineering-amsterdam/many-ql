package ql.gui.input;

import ql.ast.expression.Expr;
import ql.gui.Refreshable;
import ql.gui.control.Control;
import ql.semantics.ExprEvaluator;
import ql.semantics.ValueTable;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class ExprInput extends Input<Control> implements Refreshable
{
    private final Expr expression;

    public ExprInput(String id, Control control, Expr expression)
    {
        super(id, control, true, true);
        this.expression = expression;

        this.fillInputNode();
    }

    public Expr getExpression()
    {
        return this.expression;
    }

    @Override
    public Value evaluate(ValueTable valueTable)
    {
        Value val = ExprEvaluator.evaluate(this.getExpression(), valueTable);
        valueTable.storeEntry(this.getId(), val);
        return val;
    }

    @Override
    public Boolean isRefreshPrerequisite()
    {
        return true;
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        Value val = valueTable.getValue(this.getId());
        this.setValue(val);
    }

    @Override
    public <V> V accept(InputVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    public void setValue(Value value)
    {
        this.control.setValue(value);
    }
}