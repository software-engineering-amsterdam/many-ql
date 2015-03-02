package lang.ql.gui.input.regular;

import lang.ql.gui.GuiModelVisitor;
import lang.ql.gui.input.Input;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends Input
{
    public DecInput(String id)
    {
        super(id);
    }

    public DecInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);
    }

    public <T> T accept(GuiModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}