package ql.gui.input;

import ql.gui.control.BoolControl;
import ql.semantics.errors.Message;
import ql.semantics.errors.Warning;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends RegularInput<BoolControl>
{
    public BoolInput(String id, BoolControl control)
    {
        super(id, control);
    }

    @Override
    protected Value convertUserInputToValue()
    {
        return this.control.getBoolValue();
    }

    @Override
    protected Message getInvalidInputErrorMsg()
    {
        return new Warning("The entered value is not a valid boolean.");
    }

    @Override
    public <V> V accept(InputVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}