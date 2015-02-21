package lang.ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class StringValue extends Value<String>
{
    public StringValue(String value)
    {
        super(value);
    }

    public static StringValue getDefaultValue()
    {
        return new StringValue("");
    }

    @Override
    public Value add(Value v)
    {
        return v.addString(this);
    }

    @Override
    public Value addString(StringValue v)
    {
        return new StringValue(v.getValue() + this.getValue());
    }

    @Override
    public Value equ(Value v)
    {
        return v.equString(this);
    }

    @Override
    public Value equString(StringValue v)
    {
        return new BooleanValue(v.getValue().equals(this.getValue()));
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquString(this);
    }

    @Override
    public Value notEquString(StringValue v)
    {
        boolean r = !(v.getValue().equals(this.getValue()));
        return new BooleanValue(r);
    }
}
