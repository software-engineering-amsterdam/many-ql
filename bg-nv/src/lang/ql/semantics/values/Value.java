package lang.ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
// TODO: add handling for DateValue and the associated operations
// TODO: add support for binary operations handling both types (integer and decimal) ?
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

    public Value addDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value addString(StringValue v)
    {
        throw new IllegalStateException();
    }

    public Value sub(Value v)
    {
        throw new IllegalStateException();
    }

    public Value subInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value subDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value mul(Value v)
    {
        throw new IllegalStateException();
    }

    public Value mulInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value mulDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value div(Value v)
    {
        throw new IllegalStateException();
    }

    public Value divInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value divDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value neg()
    {
        throw new IllegalStateException();
    }

    public Value negInteger()
    {
        throw new IllegalStateException();
    }

    public Value negDecimal()
    {
        throw new IllegalStateException();
    }

    public Value pos()
    {
        throw new IllegalStateException();
    }

    public Value posInteger()
    {
        throw new IllegalStateException();
    }

    public Value posDecimal()
    {
        throw new IllegalStateException();
    }

    public Value not()
    {
        throw new IllegalStateException();
    }

    public Value gt(Value v)
    {
        throw new IllegalStateException();
    }

    public Value gtInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value gtDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value lt(Value v)
    {
        throw new IllegalStateException();
    }

    public Value ltInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value ltDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value gtEqu(Value v)
    {
        throw new IllegalStateException();
    }

    public Value gtEquInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value gtEquDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value ltEqu(Value v)
    {
        throw new IllegalStateException();
    }

    public Value ltEquInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value ltEquDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value equ(Value v)
    {
        throw new IllegalStateException();
    }

    public Value equInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value equDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value equString(StringValue v)
    {
        throw new IllegalStateException();
    }

    public Value equBoolean(BooleanValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEqu(Value v)
    {
        throw new IllegalStateException();
    }

    public Value notEquInteger(IntegerValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEquDecimal(DecimalValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEquString(StringValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEquBoolean(BooleanValue v)
    {
        throw new IllegalStateException();
    }

    public Value and(Value v)
    {
        throw new IllegalStateException();
    }

    public Value andBoolean(BooleanValue v)
    {
        throw new IllegalStateException();
    }

    public Value or(Value v)
    {
        throw new IllegalStateException();
    }

    public Value orBoolean(BooleanValue v)
    {
        throw new IllegalStateException();
    }
}
