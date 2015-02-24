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
    public StrInput()
    {
        super();
    }

    public StrInput(Boolean visible, Boolean disabled)
    {
        super(visible, disabled);
    }

    public <T> T accept(GuiVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
