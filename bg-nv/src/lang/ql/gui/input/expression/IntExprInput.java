package lang.ql.gui.input.expression;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.IntegerValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class IntExprInput extends ExprInput<TextInputControl>
{
    public IntExprInput(String id, Expr expression)
    {
        this(id, expression, true);
    }

    public IntExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, new TextField(), expression, visible);
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

        String strValue = "";
        if (!val.isUndefined())
        {
            assert val instanceof IntegerValue;
            strValue = val.toString();
        }

        this.control.setText(strValue);
    }
}
