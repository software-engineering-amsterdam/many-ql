package ql.gui.input;

import ql.gui.control.DecControl;
import ql.semantics.errors.Message;
import ql.semantics.errors.Warning;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends RegularInput<DecControl>
{
    public DecInput(String id, DecControl control)
    {
        super(id, control);
    }

    @Override
    protected Value convertUserInputToValue()
    {
        return this.control.getDecValue();
    }

    @Override
    protected Message getInvalidInputErrorMsg()
    {
        return new Warning("The entered value is not a valid decimal number.");
    }

    @Override
    public <V> V accept(InputVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}