package lang.ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class IntegerValue extends Value<Integer>
{
    public IntegerValue(Integer value)
    {
        super(value);
    }

    public static IntegerValue getDefaultValue()
    {
        return new IntegerValue(0);
    }

    public Value add(Value v)
    {
        return v.addInteger(this);
    }

    @Override
    public Value addInteger(IntegerValue value)
    {
        return new IntegerValue(this.getValue() + value.getValue());
    }

    @Override
    public Value subtract(Value v)
    {
        return v.subtractInteger(this);
    }

    @Override
    public Value subtractInteger(IntegerValue v)
    {
        return new IntegerValue(v.getValue() - this.getValue());
    }

    @Override
    public Value unaryMinus()
    {
        return this.unaryMinusInteger();
    }

    @Override
    public Value unaryMinusInteger()
    {
        return new IntegerValue(this.getValue() * -1);
    }
}