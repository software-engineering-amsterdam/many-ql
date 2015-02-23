package lang.ql.gui.input;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import lang.ql.semantics.values.BooleanValue;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends Input
{
    public BoolInput(BooleanValue value)
    {
        super(value);
    }

    public BoolInput(BooleanValue value, Boolean disabled)
    {
        super(value, disabled);
    }

}
