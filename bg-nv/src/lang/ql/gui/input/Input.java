package lang.ql.gui.input;

import javafx.scene.Node;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input
{
    private Value value;
    private Boolean disabled;

    public Input(Value value)
    {
        this.value = value;
        this.disabled = false;
    }

    public Input(Value value, Boolean disabled)
    {
        this.value = value;
        this.disabled = disabled;
    }
}
