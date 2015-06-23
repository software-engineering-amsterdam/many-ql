package ql.gui.input;

import ql.gui.control.StrControl;
import ql.semantics.errors.Message;
import ql.semantics.errors.Warning;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class StrInput extends RegularInput<StrControl>
{
    public StrInput(String id, StrControl control)
    {
        super(id, control);
    }

    @Override
    protected Value convertUserInputToValue()
    {
        return this.control.getStrValue();
    }

    @Override
    protected Message getInvalidInputErrorMsg()
    {
        return new Warning("The entered value is not a valid string.");
    }

    @Override
    public <V> V accept(InputVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
