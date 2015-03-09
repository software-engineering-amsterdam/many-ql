package lang.ql.gui.input.regular;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.errors.Warning;
import lang.ql.semantics.values.IntegerValue;
import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class IntInput extends RegularInput<TextInputControl, String>
{
    public IntInput(String id)
    {
        this(id, true, false);
    }

    public IntInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, new TextField(), visible, disabled);
    }

    public <T> T accept(ModelVisitor<T> visitor)
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
            value = new IntegerValue(intValue);
        }
        catch (NumberFormatException e)
        {
            value = new UndefinedValue();
            this.addValidationError(new Warning("The entered value is not an integer number."));
        }

        return value;
    }
}
