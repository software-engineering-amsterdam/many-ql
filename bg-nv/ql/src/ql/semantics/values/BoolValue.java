package ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class BoolValue extends Value<Boolean>
{
    public BoolValue(boolean value)
    {
        super(value);
    }

    @Override
    public Value not()
    {
        return new BoolValue(!(this.getValue()));
    }

    @Override
    public Value and(Value v)
    {
        return v.andBoolean(this);
    }

    @Override
    public Value andBoolean(BoolValue v)
    {
        return new BoolValue(v.getValue() && this.getValue());
    }

    @Override
    public Value or(Value v)
    {
        return v.orBoolean(this);
    }

    @Override
    public Value orBoolean(BoolValue v)
    {
        return new BoolValue(v.getValue() || this.getValue());
    }

    @Override
    public Value equ(Value v)
    {
        return v.equBoolean(this);
    }

    @Override
    public Value equBoolean(BoolValue v)
    {
        return new BoolValue(v.getValue().equals(this.getValue()));
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquBoolean(this);
    }

    @Override
    public Value notEquBoolean(BoolValue v)
    {
        return new BoolValue(!(v.getValue().equals(this.getValue())));
    }

    @Override
    public <T> T accept (ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
