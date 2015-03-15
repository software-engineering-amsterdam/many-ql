package ql.gui.input.expression;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import ql.ast.expression.Expr;
import ql.gui.ModelVisitor;
import ql.gui.control.ControlType;
import ql.gui.control.StringControl;
import ql.semantics.ValueTable;
import ql.semantics.values.StringValue;
import ql.semantics.values.UndefinedValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class StrExprInput extends ExprInput
{
    private final StringControl control;

    public StrExprInput(String id, StringControl control, Expr expression)
    {
        this(id, control, expression, true);
        this.inputNode = this.createInputNode(control);
    }

    public StrExprInput(String id, StringControl control, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
        this.control = control;
    }

    @Override
    protected VBox createInputNode(ControlType control)
    {
        VBox box = new VBox();
        box.getChildren().add(this.control.getGuiElement());
        box.setAlignment(Pos.TOP_RIGHT);
        box.setVisible(this.getVisible());
        return box;
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        Value val = valueTable.getValue(this.getId());

        if (!val.isUndefined())
        {
            assert val instanceof StringValue;
            this.control.setValue((StringValue)val);
        }
        else
        {
            assert val instanceof UndefinedValue;
            this.control.setValue((UndefinedValue)val);
        }
    }
}