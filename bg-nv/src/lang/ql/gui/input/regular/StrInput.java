package lang.ql.gui.input.regular;

import lang.ql.gui.ModelVisitor;
import lang.ql.gui.input.Input;

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

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
