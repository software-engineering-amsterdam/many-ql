package lang.ql.gui.input.regular;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.input.Input;
import lang.ql.semantics.ValueTable;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends RegularInput<TextInputControl>
{
    public DecInput(String id)
    {
        this(id, true, false);
    }

    public DecInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, new TextField(), visible, disabled);
    }

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
