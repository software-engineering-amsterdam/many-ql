package lang.ql.gui.input.regular;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import lang.ql.ast.expression.BoolExpr;
import lang.ql.gui.GuiVisitor;
import lang.ql.gui.input.Input;
import lang.ql.semantics.values.BooleanValue;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends Input
{
    public BoolInput(String id)
    {
        super(id);
    }

    public BoolInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);
    }

    public <T> T accept(GuiVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

}
