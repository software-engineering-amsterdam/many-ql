package lang.ql.gui.input.regular;

import javafx.scene.control.DatePicker;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class DateInput extends RegularInput<DatePicker, String>
{
    public DateInput(String id)
    {
        this(id, true, false);
    }

    public DateInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, new DatePicker(), visible, disabled);
    }

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Value convertUserInputToValue(String userInput)
    {
        this.resetValidation();
        // TODO
        return new UndefinedValue();
    }
}
