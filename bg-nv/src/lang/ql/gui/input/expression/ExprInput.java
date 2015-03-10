package lang.ql.gui.input.expression;

import lang.ql.ast.expression.Expr;
import lang.ql.gui.Refreshable;
import lang.ql.gui.control.Control;
import lang.ql.gui.input.Input;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.Value;

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

}