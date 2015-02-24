package lang.ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class BooleanValue extends Value<Boolean>
{
    public BooleanValue(boolean value)
    {
        super(value);
    }

    public static BooleanValue getDefaultValue()
    {
        return new BooleanValue(false);
    }

    @Override
    public Value not()
    {
        return new BooleanValue(!(this.getValue()));
    }

    @Override
    public Value and(Value v)
    {
        return v.andBoolean(this);
    }

    @Override
    public Value andBoolean(BooleanValue v)
    {
        return new BooleanValue(v.getValue() && this.getValue());
    }

    @Override
    public Value or(Value v)
    {
        return v.orBoolean(this);
    }

    @Override
    public Value orBoolean(BooleanValue v)
    {
        return new BooleanValue(v.getValue() || this.getValue());
    }

    @Override
    public Value equ(Value v)
    {
        return v.equBoolean(this);
    }

    @Override
    public Value equBoolean(BooleanValue v)
    {
        return new BooleanValue(v.getValue().equals(this.getValue()));
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquBoolean(this);
    }

    @Override
    public Value notEquBoolean(BooleanValue v)
    {
        return new BooleanValue(!(v.getValue().equals(this.getValue())));
    }

    @Override
    public <T> T accept (ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
