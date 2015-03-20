package ql.gui.input;

import ql.gui.control.DecControl;
import ql.semantics.errors.Message;
import ql.semantics.errors.Warning;
import ql.semantics.values.Value;

import java.math.BigDecimal;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends RegularInput<DecControl>
{
    private final Message VALIDATION_ERROR = new Warning("The entered value is not a valid decimal number.");

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
        return VALIDATION_ERROR;
    }

    @Override
    public <V> V accept(InputVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

}