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
}
