package lang.ql.gui.input.regular;

import javafx.scene.control.CheckBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends RegularInput<CheckBox, Boolean>
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

    @Override
    public Value convertUserInputToValue(Boolean userInput)
    {
        this.resetValidation();
        return new BooleanValue(userInput);
    }
}
