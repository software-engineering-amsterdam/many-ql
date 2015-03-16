package ql.gui.input;

import ql.gui.ModelVisitor;
import ql.gui.control.BoolControl;
import ql.semantics.values.BoolValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends RegularInput<Boolean>
{
    public BoolInput(String id, BoolControl control)
    {
        this(id, control, true, false);
    }

    public BoolInput(String id, BoolControl control, Boolean visible, Boolean disabled)
    {
        super(id, control, visible, disabled);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Value convertUserInputToValue(Boolean userInput)
    {
        this.resetValidation();
        return new BoolValue(userInput);
    }
}