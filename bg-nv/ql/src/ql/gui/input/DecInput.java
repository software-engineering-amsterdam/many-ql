package ql.gui.input;

import ql.gui.ModelVisitor;
import ql.gui.control.DecControl;
import ql.semantics.errors.Warning;
import ql.semantics.values.DecValue;
import ql.semantics.values.UndefValue;
import ql.semantics.values.Value;

import java.math.BigDecimal;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends RegularInput<String>
{
    public DecInput(String id, DecControl control)
    {
        this(id, control, true, false);
    }

    public DecInput(String id, DecControl control, Boolean visible, Boolean disabled)
    {
        super(id, control, visible, disabled);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Value convertUserInputToValue(String userInput)
    {
        this.resetValidation();
        userInput = userInput.trim();

        Value value;
        try
        {
            BigDecimal decValue = new BigDecimal(userInput);
            value = new DecValue(decValue);
        }
        catch (NumberFormatException e)
        {
            value = new UndefValue();
            this.addValidationError(new Warning("The entered value is not a decimal number."));
        }
        return value;
    }
}