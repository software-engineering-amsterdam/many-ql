package lang.ql.gui.input;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import lang.ql.gui.GuiVisitor;
import lang.ql.semantics.values.DecimalValue;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends Input
{
    public DecInput()
    {
        super();
    }

    public DecInput(Boolean disabled)
    {
        super(disabled);
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }
}
