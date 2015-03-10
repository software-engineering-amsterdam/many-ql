package lang.ql.gui.input.regular;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.control.Control;
import lang.ql.gui.control.ControlType;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
// TODO
public class DateInput extends RegularInput<String>
{
    public DateInput(String id)
    {
        this(id, true, false);
    }

    public DateInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);
    }

    @Override
    protected VBox createInputNode(ControlType control)
    {
        return null;
    }

    @Override
    public Value convertUserInputToValue(String userInput)
    {
        return null;
    }

    @Override
    public void attachListener(ValueTable valueTable)
    {

    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return null;
    }
}
