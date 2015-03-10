package lang.ql.gui.input.expression;

import javafx.scene.layout.VBox;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.control.Control;
import lang.ql.gui.control.ControlType;
import lang.ql.semantics.ValueTable;

/**
 * Created by Nik on 28-02-2015
 */
// TODO
public class DateExprInput extends ExprInput
{
    public DateExprInput(String id, Expr expression)
    {
        this(id, expression, true);
    }

    public DateExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return null;
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {

    }

    @Override
    protected VBox createInputNode(ControlType control)
    {
        return null;
    }
}
