package ql.gui.input.expression;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import ql.ast.expression.Expr;
import ql.gui.ModelVisitor;
import ql.gui.control.Control;
import ql.gui.control.IntegerControl;
import ql.semantics.ValueTable;
import ql.semantics.values.IntValue;
import ql.semantics.values.UndefValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class IntExprInput extends ExprInput
{
    private final IntegerControl control;

    public IntExprInput(String id, IntegerControl control, Expr expression)
    {
        this(id, control, expression, true);
        this.inputNode = this.createInputNode(control);
    }

    public IntExprInput(String id, IntegerControl control, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
        this.control = control;
    }

    @Override
    protected VBox createInputNode(Control control)
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
    public void setValue(Value value)
    {
        this.control.setValue(value);
    }
}
