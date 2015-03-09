package lang.ql.gui.input.regular;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.errors.Warning;
import lang.ql.semantics.values.DecimalValue;
import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

import java.math.BigDecimal;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends RegularInput<TextInputControl, String>
{
    public DecInput(String id)
    {
        this(id, true, false);
    }

    public DecInput(String id, Boolean visible, Boolean disabled)
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
            BigDecimal decValue = new BigDecimal(userInput);
            value = new DecimalValue(decValue);
        }
        catch (NumberFormatException e)
        {
            value = new UndefinedValue();
            this.addValidationError(new Warning("The entered value is not a decimal number."));
        }
        return value;
    }
}
