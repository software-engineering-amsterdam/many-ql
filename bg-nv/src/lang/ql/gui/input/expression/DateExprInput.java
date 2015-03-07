package lang.ql.gui.input.expression;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextInputControl;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.DateValue;
import lang.ql.semantics.values.DecimalValue;
import lang.ql.semantics.values.Value;

import java.math.BigDecimal;
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
        Value val = ExprEvaluator.evaluate(this.getExpression(), valueTable);
        valueTable.storeValue(getId(), val);

        String strValue = "";
        if (!val.isUndefined())
        {
            Date dateValue = ((DateValue)val).getValue();
            strValue = "" + dateValue; //TODO: fix this
        }

        DatePicker dateInput = this.getControl();
        //TODO: set value
        dateInput.setDisable(getDisabled());
        dateInput.setVisible(getVisible());
    }
}
