package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.gui.ModelVisitor;
import ql.semantics.values.Value;

/**
 * Created by Nik on 16-3-15.
 */
public class Spinbox extends ControlElement implements BooleanControl
{
    public Spinbox(Boolean visible, Boolean disabled)
    {
        super(visible, disabled);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {

    }

    @Override
    public void setValue(Value value)
    {

    }

    @Override
    public Node getGuiElement()
    {
        return null;
    }

    @Override
    public void addListener(ChangeListener listener)
    {

    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return null;
    }
}
