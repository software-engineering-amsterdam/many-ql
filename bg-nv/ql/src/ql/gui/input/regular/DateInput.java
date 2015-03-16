package ql.gui.input.regular;

import javafx.scene.layout.VBox;
import ql.gui.ModelVisitor;
import ql.gui.control.Control;
import ql.semantics.ValueTable;
import ql.semantics.values.Value;

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
    protected VBox createInputNode(Control control)
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
