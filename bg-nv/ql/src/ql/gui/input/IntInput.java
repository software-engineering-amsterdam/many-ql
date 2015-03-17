package ql.gui.input;

import ql.gui.ModelVisitor;
import ql.gui.control.IntControl;
import ql.semantics.errors.Message;
import ql.semantics.errors.Warning;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class IntInput extends RegularInput<IntControl>
{
    private final Message VALIDATION_ERROR = new Warning("The entered value is not a valid integer.");

    public IntInput(String id, IntControl control)
    {
        super(id, control);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    protected Value convertUserInputToValue()
    {
        Value val = this.control.getIntValue();
        if (val.isUndefined())
        {
            this.addValidationError(new Warning("The entered value is not an integer number."));
        }
        return val;
    }

    @Override
    protected Message getInvalidInputErrorMsg()
    {
        return VALIDATION_ERROR;
    }
}