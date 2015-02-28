package lang.ql.gui.input.regular;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import lang.ql.ast.expression.StrExpr;
import lang.ql.gui.GuiVisitor;
import lang.ql.gui.input.Input;
import lang.ql.semantics.values.StringValue;

/**
 * Created by Nik on 22-02-2015
 */
public class StrInput extends Input
{
    public StrInput(String id)
    {
        super(id);
    }

    public StrInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);
    }

    public <T> T accept(GuiVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
