package ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class StrValue extends Value<String>
{
    public StrValue(String value)
    {
        super(value);
    }

    @Override
    public Value add(Value v)
    {
        return v.addString(this);
    }

    @Override
    public Value addString(StrValue v)
    {
        return new StrValue(v.getValue() + this.getValue());
    }

    @Override
    public Value equ(Value v)
    {
        return v.equString(this);
    }

    @Override
    public Value equString(StrValue v)
    {
        return new BoolValue(v.getValue().equals(this.getValue()));
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquString(this);
    }

    @Override
    public Value notEquString(StrValue v)
    {
        boolean r = !(v.getValue().equals(this.getValue()));
        return new BoolValue(r);
    }

    @Override
    public <T> T accept (ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
