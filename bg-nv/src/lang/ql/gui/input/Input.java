package lang.ql.gui.input;

import lang.ql.gui.GuiElement;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input extends GuiElement
{
    private Value value;
    private Boolean disabled;

    public Input()
    {
        this.disabled = false;
    }

    public Input(Boolean disabled)
    {
        this.disabled = disabled;
    }
}
