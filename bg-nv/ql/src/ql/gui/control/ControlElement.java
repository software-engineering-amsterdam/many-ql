package ql.gui.control;

import ql.gui.GuiElement;
import ql.semantics.values.*;

/**
 * Created by Nik on 10-3-15.
 */
public abstract class ControlElement extends GuiElement
{
    public ControlElement()
    {
        super();
    }

    // the default visit methods - children implement the Control interface, which enforces them
    public Void visit(BoolValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    public Void visit(DecValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    public Void visit(IntValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    public Void visit(StrValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    public Void visit(UndefValue val)
    {
        throw new IllegalArgumentException("This value is not valid for the given control.");
    }

    public abstract <T> T accept(ControlVisitor<T> visitor);
}
