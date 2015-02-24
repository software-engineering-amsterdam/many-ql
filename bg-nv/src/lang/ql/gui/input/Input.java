package lang.ql.gui.input;

import lang.ql.gui.GuiElement;
import lang.ql.semantics.values.*;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input extends GuiElement
{
    protected Value value; // TODO: ?
    private Boolean disabled;

    public Input()
    {
        super();
        this.disabled = false;
    }

    public Input(Boolean visible, Boolean disabled)
    {
        super(visible);
        this.disabled = disabled;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
        setChanged();
        notifyObservers();
    }

    public Value getValue()
    {
        return value;
    }

    public void setValue(Value value)
    {
        throw new IllegalArgumentException();
    }
//
//    public void setValue(BooleanValue value)
//    {
//        throw new IllegalArgumentException();
//    }
//
//    public void setValue(DateValue value)
//    {
//        throw new IllegalArgumentException();
//    }
//
//    public void setValue(DecimalValue value)
//    {
//        throw new IllegalArgumentException();
//    }
//
//    public void setValue(IntegerValue value)
//    {
//        throw new IllegalArgumentException();
//    }
//
//    public void setValue(StringValue value)
//    {
//        throw new IllegalArgumentException();
//    }
}
