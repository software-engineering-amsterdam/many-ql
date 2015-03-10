package lang.ql.gui.input.expression;

import javafx.scene.control.CheckBox;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class BoolExprInput extends ExprInput<CheckBox>
{
    public BoolExprInput(String id, Expr expression)
    {
        this(id, expression, true);
    }

    public BoolExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, new CheckBox(), expression, visible);
    }

    @Override
    public <U> U accept(ModelVisitor<U> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        Value val = valueTable.getValue(this.getId());

        Boolean boolValue = false;
        if (!val.isUndefined())
        {
            assert val instanceof BooleanValue;
            boolValue = ((BooleanValue)val).getValue();
        }

        this.control.setSelected(boolValue);
    }
}
