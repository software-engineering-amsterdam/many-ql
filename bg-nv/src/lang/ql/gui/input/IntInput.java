package lang.ql.gui.input;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import lang.ql.gui.GuiVisitor;
import lang.ql.semantics.values.IntegerValue;

/**
 * Created by Nik on 22-02-2015
 */
public class IntInput extends Input
{
    public IntInput()
    {
        super();
    }

    public IntInput(Boolean disabled)
    {
        super(disabled);
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }
}
