package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.semantics.values.Value;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.math.BigDecimal;

/**
 * Created by Nik on 16-3-15.
 */
public class Spinbox extends ControlElement implements BoolControl, IntControl
{

    public Spinbox()
    {
        super();
    }

    public Spinbox(BigDecimal startValue, BigDecimal endValue, BigDecimal step)
    {
        this();
        // Boryana: :P
        throw new NotImplementedException();
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
