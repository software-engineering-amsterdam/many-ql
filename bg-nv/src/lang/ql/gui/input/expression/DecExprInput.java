package lang.ql.gui.input.expression;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.DecimalValue;
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
        Value val = valueTable.getValue(this.getId());

        String strValue = "";
        if (!val.isUndefined())
        {
            assert val instanceof DecimalValue;
            BigDecimal decValue = ((DecimalValue)val).getValue();
            strValue = "" + decValue; //TODO: fix this
        }

        TextInputControl textInput = this.getControl();
        textInput.setText(strValue);
        textInput.setDisable(this.getDisabled());
        textInput.setVisible(this.getVisible());
        textInput.setManaged(this.getVisible());
    }
}
