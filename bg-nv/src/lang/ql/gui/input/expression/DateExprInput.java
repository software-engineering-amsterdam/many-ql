package lang.ql.gui.input.expression;

import javafx.scene.control.DatePicker;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.DateValue;
import lang.ql.semantics.values.Value;

import java.util.Date;

/**
 * Created by Nik on 28-02-2015
 */
public class DateExprInput extends ExprInput<DatePicker>
{
    public DateExprInput(String id, Expr expression)
    {
        this(id, expression, true);
    }

    public DateExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, new DatePicker(), expression, visible);
    }

    @Override
    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void update(ValueTable valueTable)
    {
        Value val = valueTable.getValue(this.getId());

        if (!val.isUndefined())
        {
            assert val instanceof DateValue;
            Date dateValue = ((DateValue)val).getValue();
        }

        DatePicker dateInput = this.getControl();
        //TODO: set value
    }
}
