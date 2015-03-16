package ql.gui.control;

import ql.gui.GuiElement;
import ql.semantics.values.*;

/**
 * Created by Nik on 10-3-15.
 */
public abstract class ControlElement extends GuiElement implements Control
{
    public ControlElement(Boolean visible, Boolean disabled)
    {

    }

    @Override
    public Void visit(BooleanValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(DateValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(DecimalValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(IntegerValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(StringValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(UndefinedValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }
}
