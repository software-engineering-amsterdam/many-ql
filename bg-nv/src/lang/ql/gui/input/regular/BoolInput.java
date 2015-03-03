package lang.ql.gui.input.regular;

import javafx.scene.control.CheckBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.input.Input;
import lang.ql.semantics.ValueTable;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends RegularInput<CheckBox>
{
    public BoolInput(String id)
    {
        this(id, true, false);
    }

    public BoolInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, new CheckBox(), visible, disabled);
    }

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
