package ql.gui.input.expression;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import ql.ast.expression.Expr;
import ql.gui.ModelVisitor;
import ql.gui.control.BooleanControl;
import ql.gui.control.ControlType;
import ql.semantics.ValueTable;
import ql.semantics.values.BoolValue;
import ql.semantics.values.UndefValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class BoolExprInput extends ExprInput
{
    private final BooleanControl control;

    public BoolExprInput(String id, BooleanControl control, Expr expression)
    {
        this(id, control, expression, true);
    }

    public BoolExprInput(String id, BooleanControl control, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
        this.control = control;
        this.inputNode = this.createInputNode(control);
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
            assert val instanceof BoolValue;
            this.control.setValue(((BoolValue)val));
        }
        else
        {
            assert val instanceof UndefValue;
            this.control.setValue(((UndefValue)val));
        }
    }
}
