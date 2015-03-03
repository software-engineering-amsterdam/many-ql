package lang.ql.gui.input.expression;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.DecimalValue;
import lang.ql.semantics.values.IntegerValue;
import lang.ql.semantics.values.Value;

import java.math.BigDecimal;

/**
 * Created by Nik on 28-02-2015
 */
public class DecExprInput extends ExprInput<TextInputControl>
{
    public DecExprInput(String id, Expr expression)
    {
        this(id, expression, true);
    }

    public DecExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, new TextField(), expression, visible);
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
            BigDecimal decValue = ((DecimalValue)val).getValue();
            strValue = "" + decValue; //TODO: fix this
        }

        TextInputControl textInput = this.getControl();
        textInput.setText(strValue);
        textInput.setDisable(getDisabled());
        textInput.setVisible(getVisible());
    }
}
