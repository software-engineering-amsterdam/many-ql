package lang.ql.gui.input.expression;

import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.StringValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class StrExprInput extends ExprInput<TextInputControl>
{

    public StrExprInput(String id, Expr expression)
    {
        this(id, expression, true);
    }

    public StrExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, new TextField(), expression, visible);
    }


    public void update(ValueTable valueTable)
    {
        Value val = ExprEvaluator.evaluate(this.getExpression(), valueTable);
        valueTable.storeValue(getId(), val);

        String strValue = "";
        if (!val.isUndefined())
        {
            strValue = ((StringValue)val).getValue();
        }

        TextInputControl textInput = this.getControl();
        textInput.setText(strValue);
        textInput.setDisable(getDisabled());
        textInput.setVisible(getVisible());
    }

    @Override
    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}