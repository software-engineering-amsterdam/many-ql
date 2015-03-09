package lang.ql.gui.input.expression;

import javafx.scene.control.Control;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.Refreshable;
import lang.ql.gui.input.Input;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public abstract class ExprInput<T extends Control> extends Input<T> implements Refreshable
{
    final private Expr expression;


    public ExprInput(String id, T control, Expr expression, Boolean visible)
    {
        super(id, control, visible, true);
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
    public Boolean isPrerequisite()
    {
        return true;
    }
}
