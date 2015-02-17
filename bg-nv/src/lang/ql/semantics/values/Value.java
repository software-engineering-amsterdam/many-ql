package lang.ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public abstract class Value<T>
{
    private T value;

    public Value(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }

    public Value add(Value v)
    {
        throw new IllegalStateException();
    }

    public Value addInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value addString(StringValue v)
    {
        throw new IllegalStateException();
    }

    public Value subtract(Value v)
    {
        throw new IllegalStateException();
    }

    public Value subtractInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value unaryMinus()
    {
        throw new IllegalStateException();
    }

    public Value unaryMinusInteger()
    {
        throw new IllegalStateException();
    }

    public Value unaryMinusDecimal()
    {
        throw new IllegalStateException();
    }

    //public Value
}
