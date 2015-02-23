package lang.ql.gui.input;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import lang.ql.gui.GuiVisitor;
import lang.ql.semantics.values.BooleanValue;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends Input
{
    public BoolInput()
    {
        super();
    }

    public BoolInput(Boolean disabled)
    {
        super(disabled);
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }

}
