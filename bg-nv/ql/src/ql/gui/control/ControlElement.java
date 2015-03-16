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
    public Void visit(BoolValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(DateValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(DecValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(IntValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(StrValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    @Override
    public Void visit(UndefValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }
}
