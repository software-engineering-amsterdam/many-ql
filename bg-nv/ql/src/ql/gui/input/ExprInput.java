package ql.gui.input;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import ql.ast.expression.Expr;
import ql.gui.ModelVisitor;
import ql.gui.Refreshable;
import ql.gui.control.Control;
import ql.semantics.ExprEvaluator;
import ql.semantics.ValueTable;
import ql.semantics.ValueTableEntry;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
public class ExprInput extends Input implements Refreshable
{
    private final Expr expression;

    public ExprInput(String id, Control control, Expr expression)
    {
        super(id, control, true, true);
        this.expression = expression;
        this.inputNode = this.createInputNode(this.control);
        this.control.setDisabled(true);
    }

    public Expr getExpression()
    {
        return this.expression;
    }

    @Override
    public Value evaluate(ValueTable valueTable)
    {
        Value val = ExprEvaluator.evaluate(this.getExpression(), valueTable);
        valueTable.storeEntry(new ValueTableEntry(this.getId(), val));
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