package ql.gui.input;

import ql.gui.ModelVisitor;
import ql.gui.control.IntControl;
import ql.semantics.errors.Warning;
import ql.semantics.values.IntValue;
import ql.semantics.values.UndefValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class IntInput extends RegularInput<String>
{

    public IntInput(String id, IntControl control)
    {
        this(id, control, true, false);
    }

    public IntInput(String id, IntControl control, Boolean visible, Boolean disabled)
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
            Integer intValue = Integer.parseInt(userInput);
            value = new IntValue(intValue);
        }
        catch (NumberFormatException e)
        {
            value = new UndefValue();
            this.addValidationError(new Warning("The entered value is not an integer number."));
        }

        return value;
    }
}