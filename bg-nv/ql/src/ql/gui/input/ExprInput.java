package ql.gui.input;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import ql.ast.expression.Expr;
import ql.gui.ModelVisitor;
import ql.gui.Refreshable;
import ql.gui.control.Control;
import ql.semantics.ExprEvaluator;
import ql.semantics.ValueTable;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class ExprInput extends Input implements Refreshable
{
    final private Expr expression;
    final private Control control;

    public ExprInput(String id, Expr expression, Control control)
    {
        this(id, expression, control, true);
    }

    public ExprInput(String id, Expr expression, Control control, Boolean visible)
    {
        super(id, visible, true);
        this.expression = expression;
        this.control = control;
        this.inputNode = this.createInputNode(control);
    }

    public Expr getExpression()
    {
        return this.expression;
    }

    @Override
    public Value evaluate(ValueTable valueTable)
    {
        Value val = ExprEvaluator.evaluate(this.getExpression(), valueTable);
        valueTable.storeValue(this.getId(), val);
        return val;
    }

    @Override
    public Boolean isRefreshPrerequisite()
    {
        return true;
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        Value val = valueTable.getValue(this.getId());
        this.setValue(val);
    }

    @Override
    protected VBox createInputNode(Control control)
    {
        VBox box = new VBox();
        box.getChildren().add(this.control.getControlNode());
        box.setAlignment(Pos.TOP_RIGHT);
        box.setVisible(this.getVisible());
        return box;
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    public void setValue(Value value)
    {
        this.control.setValue(value);
    }

}