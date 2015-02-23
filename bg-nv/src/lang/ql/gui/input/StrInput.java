package lang.ql.gui.input;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import lang.ql.gui.GuiVisitor;
import lang.ql.semantics.values.StringValue;

/**
 * Created by Nik on 22-02-2015
 */
public class StrInput extends Input
{
    public StrInput(StringValue value)
    {
        super(value);
    }

    public StrInput(StringValue value, Boolean disabled)
    {
        super(value, disabled);
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }
}
