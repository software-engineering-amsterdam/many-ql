package ql.gui.input;

import ql.gui.ModelVisitor;
import ql.gui.control.StrControl;
import ql.semantics.values.StrValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class StrInput extends RegularInput<String>
{

    public StrInput(String id, StrControl control)
    {
        this(id, control, true, false);
    }

    public StrInput(String id, StrControl control, Boolean visible, Boolean disabled)
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
        return new StrValue(userInput);
    }
}
