package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.gui.ModelVisitor;
import ql.semantics.values.Value;

/**
 * Created by Nik on 16-3-15.
 */
public class Spinbox extends ControlElement implements BoolControl, IntControl
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
    public Node getControlNode()
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
        return visitor.visit(this);
    }

    @Override
    public Value getBoolValue()
    {
        return null;
    }

    @Override
    public Value getIntValue()
    {
        return null;
    }

    @Override
    public <T> T accept(ControlVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
